package com.lyh.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.remote.ShortLinkRemoteService;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShorLinkPageRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkCreateRespDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 *@title ShortLinkController
 *@description 短链接后管控制层
 *@author LYH
 *@version 1.0
 *@create 2024/2/5 21:09
 */
@RestController
@AllArgsConstructor
public class ShortLinkController {
    /**
     * 创建短链接
     */
    @PostMapping(value = "/api/shortlink/admin/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        ShortLinkRemoteService shortLinkRemoteService=new ShortLinkRemoteService() {
        };
        return shortLinkRemoteService.createShortLink(requestParam);
    }
    /**
     * 分页查询短链接
     */
    @GetMapping(value = "/api/shortlink/admin/page")
    //get请求，它传递的是param（接在url后面），所以不拿@RequestBody接（请求体）
    public Result<IPage<ShorLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        ShortLinkRemoteService shortLinkRemoteService=new ShortLinkRemoteService() {
        };
        return shortLinkRemoteService.pageShortLink(requestParam);
    }
}
