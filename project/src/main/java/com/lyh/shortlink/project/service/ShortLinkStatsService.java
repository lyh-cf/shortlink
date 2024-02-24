package com.lyh.shortlink.project.service;

import com.lyh.shortlink.project.dto.request.ShortLinkStatsReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkStatsRespDTO;

/*
 *@title ShortLinkStatsService
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 21:27
 */
public interface ShortLinkStatsService {
    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}
