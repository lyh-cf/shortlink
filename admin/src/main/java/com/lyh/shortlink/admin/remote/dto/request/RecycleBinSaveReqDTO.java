package com.lyh.shortlink.admin.remote.dto.request;

import lombok.Data;

/*
 *@title RecycleBinSaveReqDTO
 *@description 回收站保存请求对象
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 21:25
 */
@Data
public class RecycleBinSaveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
