package com.lyh.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.common.convention.result.BaseResponse;
import com.lyh.shortlink.project.common.convention.result.Result;
import com.lyh.shortlink.project.dto.request.ShortLinkGroupStatsAccessRecordReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkGroupStatsReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkStatsAccessRecordReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkStatsReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkStatsAccessRecordRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkStatsRespDTO;
import com.lyh.shortlink.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@title ShortLinkStatsController
 *@description 短链接监控控制层
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 21:26
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {
    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/shortlink/project/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return BaseResponse.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }
    /**
     * 访问单个短链接指定时间内访问记录监控数据
     */
    @GetMapping("/api/shortlink/project/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return BaseResponse.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }
    /**
     * 访问分组短链接指定时间内监控数据
     */
    @GetMapping("/api/shortlink/project/stats/group")
    public Result<ShortLinkStatsRespDTO> groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
        return BaseResponse.success(shortLinkStatsService.groupShortLinkStats(requestParam));
    }
    /**
     * 访问分组短链接指定时间内访问记录监控数据
     */
    @GetMapping("/api/shortlink/project/stats/access-record/group")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam) {
        return BaseResponse.success(shortLinkStatsService.groupShortLinkStatsAccessRecord(requestParam));
    }
}
