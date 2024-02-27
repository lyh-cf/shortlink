package com.lyh.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.dto.request.ShortLinkStatsAccessRecordReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkStatsReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkStatsAccessRecordRespDTO;
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
    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
