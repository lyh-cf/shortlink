package com.lyh.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.admin.common.biz.user.UserContext;
import com.lyh.shortlink.admin.common.enums.GroupErrorCodeEnum;
import com.lyh.shortlink.admin.common.exception.ClientException;
import com.lyh.shortlink.admin.dao.entity.GroupDO;
import com.lyh.shortlink.admin.dao.mapper.GroupMapper;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSaveReqDTO;
import com.lyh.shortlink.admin.dto.response.ShortLinkGroupRespDTO;
import com.lyh.shortlink.admin.service.GroupService;
import com.lyh.shortlink.admin.util.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@title GroupServiceImpl
 *@description 短链接分组接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 21:25
 */
@Service
@Slf4j
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    @Override
    public void saveGroup(ShortLinkGroupSaveReqDTO requestParam) {
        String gid = RandomGenerator.generateRandom();
        while (hasGid(gid)) {
            gid = RandomGenerator.generateRandom();
        }
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(requestParam.getName())
                .username(UserContext.getUsername())
                .sortOrder(0)
                .build();
        int inserted = baseMapper.insert(groupDO);
        if(inserted<1){
            throw new ClientException(GroupErrorCodeEnum.GROUP_SAVE_ERROR);
        }
    }

    @Override
    public List<ShortLinkGroupRespDTO> getShortLinkGroupList() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder)
                .orderByDesc(GroupDO::getUpdateTime);
        List<GroupDO>groupDOList=baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOList, ShortLinkGroupRespDTO.class);
    }

    private Boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, UserContext.getUsername());
        return baseMapper.selectOne(queryWrapper) != null;
    }
}
