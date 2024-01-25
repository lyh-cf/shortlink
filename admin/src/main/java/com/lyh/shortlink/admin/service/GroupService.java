package com.lyh.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.shortlink.admin.dao.entity.GroupDO;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSaveReqDTO;

/*
 *@title GroupService
 *@description 短链接分组接口层
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 21:27
 */
public interface GroupService extends IService<GroupDO> {
    /**
     * 新增短链接分组
     * @param groupName
     */
    void saveGroup(ShortLinkGroupSaveReqDTO requestParam);
}
