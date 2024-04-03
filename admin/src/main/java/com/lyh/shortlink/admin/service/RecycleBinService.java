package com.lyh.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkRecycleBinPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkPageRespDTO;

/*
 *@title RecycleBinService
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/2/20 11:17
 */
public interface RecycleBinService {

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam 请求参数
     * @return 返回参数包装
     */
    Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
