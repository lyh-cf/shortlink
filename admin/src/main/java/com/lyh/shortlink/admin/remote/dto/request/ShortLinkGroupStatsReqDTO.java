package com.lyh.shortlink.admin.remote.dto.request;

import lombok.Data;

/*
 *@title ShortLinkGroupStatsReqDTO
 *@description 分组短链接监控请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/4/3 16:19
 */
@Data
public class ShortLinkGroupStatsReqDTO {

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
}