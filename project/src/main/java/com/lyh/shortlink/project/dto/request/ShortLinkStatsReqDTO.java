package com.lyh.shortlink.project.dto.request;

import lombok.Data;

/*
 *@title ShortLinkStatsReqDTO
 *@description 获取单个短链接监控数据请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 21:27
 */
@Data
public class ShortLinkStatsReqDTO {
    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;
}
