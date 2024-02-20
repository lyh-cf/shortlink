package com.lyh.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.dto.request.RecycleBinRecoverReqDTO;
import com.lyh.shortlink.project.dto.request.RecycleBinRemoveReqDTO;
import com.lyh.shortlink.project.dto.request.RecycleBinSaveReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkRecycleBinPageReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkPageRespDTO;

/*
 *@title RecycleBinService
 *@description 回收站管理接口层
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 21:25
 */
public interface RecycleBinService {
    /**
     * 保存回收站
     *
     * @param requestParam 请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
    /**
     * 分页查询短链接
     *
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
    /**
     * 从回收站恢复短链接
     *
     * @param requestParam 恢复短链接请求参数
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);
    /**
     * 从回收站移除短链接
     *
     * @param requestParam 移除短链接请求参数
     */
    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}
