package com.lyh.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.admin.common.convention.exception.ClientException;
import com.lyh.shortlink.admin.common.convention.exception.ServiceException;
import com.lyh.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.lyh.shortlink.admin.dao.entity.UserDO;
import com.lyh.shortlink.admin.dao.mapper.UserMapper;
import com.lyh.shortlink.admin.dto.request.UserLoginReqDTO;
import com.lyh.shortlink.admin.dto.request.UserRegisterReqDTO;
import com.lyh.shortlink.admin.dto.request.UserUpdateReqDTO;
import com.lyh.shortlink.admin.dto.response.UserLoginRespDTO;
import com.lyh.shortlink.admin.dto.response.UserRespDTO;
import com.lyh.shortlink.admin.service.GroupService;
import com.lyh.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.lyh.shortlink.admin.common.constant.RedisCacheConstant.*;

/*
 *@title UserServiceImpl
 *@description 用户接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 22:14
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    private final RedissonClient redissonClient;
    private final StringRedisTemplate stringRedisTemplate;
    private final GroupService groupService;
    @Override
    public UserRespDTO getUserByUserName(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        UserRespDTO result = new UserRespDTO();
        if (userDO != null) {
            BeanUtils.copyProperties(userDO, result);       // 此方法需要判空才可以，否则会报错
            return result;
        } else throw new ClientException(UserErrorCodeEnum.USER_NULL);
    }

    @Override
    public Boolean hasUserName(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        if (hasUserName(requestParam.getUsername())) {
            throw new ClientException(UserErrorCodeEnum.USER_NAME_EXIST);
        }
        //不加 requestParam.getUsername() 将变成全局锁
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        try {
            /**
             * <b>并发请求</b>
             */
            if (lock.tryLock()) {
                try {
                    int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                    if (inserted < 1) {
                        throw new ServiceException(UserErrorCodeEnum.USER_SAVE_ERROR);
                    }
                    //唯一索引防止重复插入
                } catch (DuplicateKeyException e) {
                    throw new ServiceException(UserErrorCodeEnum.USER_NAME_EXIST);
                }
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                //給用户创建默认分组
                groupService.saveGroup(requestParam.getUsername(),"默认分组");
                return;
            }
            /**
             * <b>获取锁失败的线程</b>
             */
            throw new ClientException(UserErrorCodeEnum.USER_NAME_EXIST);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {
        // TODO 验证当前用户名是否为登录用户
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername());
        int update = baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class), updateWrapper);
        if (update < 1) {
            throw new ServiceException(UserErrorCodeEnum.USER_UPDATE_ERROR);
        }
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword())
                .eq(UserDO::getDelFlag, 0);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if(userDO==null){
            throw new ClientException(UserErrorCodeEnum.USER_LOGIN_ERROR);
        }
        Map<Object ,Object> hasLoginMap = stringRedisTemplate.opsForHash().entries(LOCK_TOKEN_KEY + requestParam.getUsername());
        if (CollUtil.isNotEmpty(hasLoginMap)) {
            String token = hasLoginMap.keySet().stream()
                    .findFirst()
                    .map(Object::toString)
                    .orElseThrow(() -> new ClientException("用户登录错误"));
            return new UserLoginRespDTO(token);
        }
        /*
         * Hash 结构存储
         */
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString().replace("-", "");
        stringRedisTemplate.opsForHash().put(LOCK_TOKEN_KEY+requestParam.getUsername(),token, JSON.toJSONString(userDO));
        stringRedisTemplate.expire(LOCK_TOKEN_KEY+requestParam.getUsername(),USER_TOKEN_TTL, TimeUnit.MINUTES);
        return new UserLoginRespDTO(token);
    }

    @Override
    public Boolean checkLogin(String username,String token) {
        return stringRedisTemplate.opsForHash().get(LOCK_TOKEN_KEY+username,token)!=null;
    }

    @Override
    public void logout(String username, String token) {
        if(checkLogin(username,token)){
            stringRedisTemplate.delete(LOCK_TOKEN_KEY+username);
            return;
        }
        throw new ClientException(UserErrorCodeEnum.USER_NOT_LOGIN);
    }
}
