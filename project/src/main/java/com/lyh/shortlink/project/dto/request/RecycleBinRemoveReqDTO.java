package com.lyh.shortlink.project.dto.request;

import lombok.Data;

/*
 *@title RecycleBinRemoveReqDTO
 *@description 回收站移除功能请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/2/20 19:11
 */
@Data
public class RecycleBinRemoveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
