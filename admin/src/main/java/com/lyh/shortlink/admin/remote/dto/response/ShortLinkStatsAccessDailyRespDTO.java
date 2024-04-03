package com.lyh.shortlink.admin.remote.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/*
 *@title ShortLinkStatsAccessDailyRespDTO
 *@description 短链接基础访问监控响应参数
 *@author LYH
 *@version 1.0
 *@create 2024/4/3 16:07
 */
@Data
public class ShortLinkStatsAccessDailyRespDTO {

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    /**
     * 访问量
     */
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立IP数
     */
    private Integer uip;
}
