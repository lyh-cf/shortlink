package com.lyh.shortlink.project.dto.request;

import lombok.Data;

/*
 *@title RecycleBinRecoverReqDTO
 *@description 回收站恢复功能请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/2/20 18:18
 */
@Data
public class RecycleBinRecoverReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
