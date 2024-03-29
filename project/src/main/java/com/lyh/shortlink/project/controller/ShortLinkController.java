package com.lyh.shortlink.project.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.common.convention.result.BaseResponse;
import com.lyh.shortlink.project.common.convention.result.Result;
import com.lyh.shortlink.project.dto.request.ShortLinkBatchCreateReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkUpdateReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkBatchCreateRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkCreateRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkGroupCountQueryRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkPageRespDTO;
import com.lyh.shortlink.project.handle.CustomBlockHandler;
import com.lyh.shortlink.project.service.ShortLinkService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lyh.shortlink.project.common.constant.SentinelConstant.CREATE_SHORT_LINK;
import static com.lyh.shortlink.project.common.constant.SentinelConstant.CREATE_SHORT_LINK_BLOCK_HANDLER_METHOD;

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
     * 短链接跳转
     */
    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri")String shortUri, ServletRequest request, ServletResponse response){
         shortLinkService.restoreUrl(shortUri,request,response);
    }
    /**
     * 创建短链接
     */
    @PostMapping(value = "/api/shortlink/project/create")
    @SentinelResource(
            value = CREATE_SHORT_LINK,
            blockHandler = CREATE_SHORT_LINK_BLOCK_HANDLER_METHOD,
            blockHandlerClass = CustomBlockHandler.class
    )
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        ShortLinkCreateRespDTO shortLink = shortLinkService.createShortLink(requestParam);
        return BaseResponse.success(shortLink);
    }
    /**
     * 批量创建短链接
     */
    @PostMapping("/api/shortlink/project/create/batch")
    public Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam) {
        return BaseResponse.success(shortLinkService.batchCreateShortLink(requestParam));
    }
    /**
     * 修改短链接
     */
    @PostMapping(value = "/api/shortlink/project/update")
    public Result<Void>updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam){
        shortLinkService.updateShortLink(requestParam);
        return BaseResponse.success();
    }
    /**
     * 分页查询短链接
     */
    @GetMapping(value = "/api/shortlink/project/page")
    //get请求，它传递的是param（接在url后面），所以不拿@RequestBody接（请求体）
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return BaseResponse.success(shortLinkService.pageShortLink(requestParam));
    }
    /**
     * 查询短链接分组内短链接数量
     */
    @GetMapping(value = "/api/shortlink/project/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>>listGroupShortLinkCount(@RequestParam("requestParam") List<String>requestParam){
          return BaseResponse.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }
}
