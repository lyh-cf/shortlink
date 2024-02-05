package com.lyh.shortlink.project.dto.response;

import lombok.Data;

import java.util.Date;

/*
 *@title ShorLinkPageRespDTO
 *@description 短链接分页查询响应对象
 *@author LYH
 *@version 1.0
 *@create 2024/2/4 20:16
 */
@Data
public class ShorLinkPageRespDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;
    /**
     * 网站图标
     */
    private String favicon;

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
