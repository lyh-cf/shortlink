package com.lyh.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.remote.ShortLinkRemoteService;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkUpdateReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkPageRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkCreateRespDTO;
import org.springframework.web.bind.annotation.*;

/*
 *@title ShortLinkController
 *@description 短链接后管控制层
 *@author LYH
 *@version 1.0
 *@create 2024/2/5 21:09
 */
@RestController
public class ShortLinkController {
    ShortLinkRemoteService shortLinkRemoteService=new ShortLinkRemoteService() {
    };
    /**
     * 创建短链接
     */
    @PostMapping(value = "/api/shortlink/admin/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return shortLinkRemoteService.createShortLink(requestParam);
    }
    /**
     * 修改短链接
     */
    @PostMapping(value = "/api/shortlink/admin/update")
    public Result<Void>updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam){
        shortLinkRemoteService.updateShortLink(requestParam);
        return BaseResponse.success();
    }
    /**
     * 分页查询短链接
     */
    @GetMapping(value = "/api/shortlink/admin/page")
    //get请求，它传递的是param（接在url后面），所以不拿@RequestBody接（请求体）
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return shortLinkRemoteService.pageShortLink(requestParam);
    }
}
