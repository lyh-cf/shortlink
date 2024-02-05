package com.lyh.shortlink.admin.remote.dto.request;

import lombok.Data;

import java.util.Date;

/*
 *@title ShortLinkCreateReqDTO
 *@description 短链接创建请求对象
 *@author LYH
 *@version 1.0
 *@create 2024/2/1 17:40
 */
@Data
public class ShortLinkCreateReqDTO {

    /**
     * 域名
     */
    private String domain;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 创建类型 0：控制台 1：接口
     */
    private int createdType;

    /**
     * 有效期类型 0：永久有效 1：用户自定义
     */
    private int validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    private String describe;
}
