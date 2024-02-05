package com.lyh.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.common.convention.result.BaseResponse;
import com.lyh.shortlink.project.common.convention.result.Result;
import com.lyh.shortlink.project.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.project.dto.response.ShorLinkPageRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkCreateRespDTO;
import com.lyh.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 *@title ShortLinkController
 *@description 短链接控制层
 *@author LYH
 *@version 1.0
 *@create 2024/2/1 17:20
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;
    /**
     * 创建短链接
     */
    @PostMapping(value = "/api/shortlink/project/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        ShortLinkCreateRespDTO shortLink = shortLinkService.createShortLink(requestParam);
        return BaseResponse.success(shortLink);
    }
    /**
     * 分页查询短链接
     */
    @GetMapping(value = "/api/shortlink/project/page")
    //get请求，它传递的是param（接在url后面），所以不拿@RequestBody接（请求体）
    public Result<IPage<ShorLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return BaseResponse.success(shortLinkService.pageShortLink(requestParam));
    }
}
