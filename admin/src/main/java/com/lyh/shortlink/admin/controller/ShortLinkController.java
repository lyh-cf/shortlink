package com.lyh.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.remote.ShortLinkRemoteService;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkBatchCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkUpdateReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkBaseInfoRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkBatchCreateRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkCreateRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkPageRespDTO;
import com.lyh.shortlink.admin.util.EasyExcelWebUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 批量创建短链接
     */
    @SneakyThrows
    @PostMapping("/api/shortlink/admin/create/batch")
    public void batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<ShortLinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkRemoteService.batchCreateShortLink(requestParam);
        if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
            List<ShortLinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
            EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", ShortLinkBaseInfoRespDTO.class, baseLinkInfos);
        }
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
