package com.lyh.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.shortlink.admin.dao.entity.GroupDO;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSaveReqDTO;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import com.lyh.shortlink.admin.dto.response.ShortLinkGroupRespDTO;

import java.util.List;

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
     */
    void saveGroup(ShortLinkGroupSaveReqDTO requestParam);
    /**
     * 查询用户的短链接分组集合
     */
    List<ShortLinkGroupRespDTO> getShortLinkGroupList();
    /**
     * 修改短链接分组名
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);
    /**
     * 删除短链接分组
     */
    void deleteGroup(String gid);
}
