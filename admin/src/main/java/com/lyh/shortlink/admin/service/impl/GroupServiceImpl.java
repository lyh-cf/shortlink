package com.lyh.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.admin.common.biz.user.UserContext;
import com.lyh.shortlink.admin.common.convention.exception.ClientException;
import com.lyh.shortlink.admin.common.convention.exception.ServiceException;
import com.lyh.shortlink.admin.common.enums.GroupErrorCodeEnum;
import com.lyh.shortlink.admin.dao.entity.GroupDO;
import com.lyh.shortlink.admin.dao.mapper.GroupMapper;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSortReqDTO;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import com.lyh.shortlink.admin.dto.response.ShortLinkGroupRespDTO;
import com.lyh.shortlink.admin.remote.ShortLinkActualRemoteService;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkGroupCountQueryRespDTO;
import com.lyh.shortlink.admin.service.GroupService;
import com.lyh.shortlink.admin.util.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyh.shortlink.admin.common.constant.RedisCacheConstant.LOCK_GROUP_CREATE_KEY;

/*
 *@title GroupServiceImpl
 *@description 短链接分组接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 21:25
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    private final TransactionTemplate transactionTemplate;
    private final RedissonClient redissonClient;
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;
    @Value("${shortlink.group.max-num}")
    private Integer groupMaxNum;
    @Override
    public void saveGroup(String groupName) {
        this.saveGroup(UserContext.getUsername(),groupName);
    }

    @Override
    public void saveGroup(String username, String groupName) {
        RLock lock = redissonClient.getLock(String.format(LOCK_GROUP_CREATE_KEY, username));
        lock.lock();
        try {
            LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                    .eq(GroupDO::getUsername, username)
                    .eq(GroupDO::getDelFlag, 0);
            List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
            if (CollUtil.isNotEmpty(groupDOList) && groupDOList.size() == groupMaxNum) {
                throw new ClientException(String.format("已超出最大分组数：%d", groupMaxNum));
            }
            String gid = RandomGenerator.generateRandom();
            while (hasGid(username,gid)) {
                gid = RandomGenerator.generateRandom();
            }
            GroupDO groupDO = GroupDO.builder()
                    .gid(gid)
                    .sortOrder(0)
                    .username(username)
                    .name(groupName)
                    .build();
            int inserted = baseMapper.insert(groupDO);
            if (inserted < 1) {
                throw new ServiceException(GroupErrorCodeEnum.GROUP_SAVE_ERROR);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<ShortLinkGroupRespDTO> getShortLinkGroupList() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder)
                .orderByDesc(GroupDO::getUpdateTime);
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        List<ShortLinkGroupCountQueryRespDTO> gids = shortLinkActualRemoteService.listGroupShortLinkCount(groupDOList.stream().map(GroupDO::getGid).toList()).getData();
        List<ShortLinkGroupRespDTO> results = BeanUtil.copyToList(groupDOList, ShortLinkGroupRespDTO.class);
        Map<String, Integer> counts = gids.stream().collect(Collectors.toMap(ShortLinkGroupCountQueryRespDTO::getGid, ShortLinkGroupCountQueryRespDTO::getShortLinkCount));
        return results.stream().peek(result -> result.setShortLinkCount(counts.getOrDefault(result.getGid(),0))).toList();
    }

    @Override
    public void updateGroup(ShortLinkGroupUpdateReqDTO requestParam) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, requestParam.getGid())
                .eq(GroupDO::getDelFlag, 0);
        GroupDO groupDO = GroupDO.builder()
                .name(requestParam.getName())
                .build();
        int update = baseMapper.update(groupDO, updateWrapper);
        if (update < 1) {
            throw new ServiceException(GroupErrorCodeEnum.GROUP_UPDATE_ERROR);
        }
    }

    @Override
    public void deleteGroup(String gid) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getDelFlag, 0);
        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(1);
        int update = baseMapper.update(groupDO, updateWrapper);
        if (update < 1) {
            throw new ServiceException(GroupErrorCodeEnum.GROUP_DELETE_ERROR);
        }
    }

    @Override
    @Transactional
    public void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    requestParam.forEach(each -> {
                        GroupDO groupDO = GroupDO.builder()
                                .sortOrder(each.getSortOrder())
                                .build();
                        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                                .eq(GroupDO::getUsername, UserContext.getUsername())
                                .eq(GroupDO::getGid, each.getGid())
                                .eq(GroupDO::getDelFlag, 0);
                        baseMapper.update(groupDO, updateWrapper);
                    });
                } catch (Exception e) {
                    log.error(e.getCause().toString());
                    //回滚
                    transactionStatus.setRollbackOnly();
                    throw new ServiceException(GroupErrorCodeEnum.GROUP_SORT_ERROR);
                }
            }
        });
    }

    private Boolean hasGid(String username,String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, Optional.ofNullable(username).orElse(UserContext.getUsername()));
        return baseMapper.selectOne(queryWrapper) != null;
    }
}
