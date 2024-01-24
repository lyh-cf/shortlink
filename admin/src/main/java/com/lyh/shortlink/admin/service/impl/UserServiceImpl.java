package com.lyh.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.lyh.shortlink.admin.common.exception.ClientException;
import com.lyh.shortlink.admin.dao.entity.UserDO;
import com.lyh.shortlink.admin.dao.mapper.UserMapper;
import com.lyh.shortlink.admin.dto.response.UserRespDTO;
import com.lyh.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/*
 *@title UserServiceImpl
 *@description 用户接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 22:14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
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
}
