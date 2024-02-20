package com.lyh.shortlink.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lyh.shortlink.admin.common.biz.user.UserContext;
import com.lyh.shortlink.admin.common.convention.exception.ServiceException;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.common.enums.GroupErrorCodeEnum;
import com.lyh.shortlink.admin.dao.entity.GroupDO;
import com.lyh.shortlink.admin.dao.mapper.GroupMapper;
import com.lyh.shortlink.admin.remote.ShortLinkRemoteService;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkRecycleBinPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkPageRespDTO;
import com.lyh.shortlink.admin.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@title RecycleBinServiceImpl
 *@description URL 回收站接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/2/20 11:18
 */
@Service
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements RecycleBinService {
    private final GroupMapper groupMapper;

    ShortLinkRemoteService shortLinkRemoteService=new ShortLinkRemoteService() {
    };

    @Override
    public Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(groupDOList)) {
            throw new ServiceException(GroupErrorCodeEnum.GROUP_USER_NULL);
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        return shortLinkRemoteService.pageRecycleBinShortLink(requestParam.getGidList(), requestParam.getCurrent(), requestParam.getSize());
    }
}
