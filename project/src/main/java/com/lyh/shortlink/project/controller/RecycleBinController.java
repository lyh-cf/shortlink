package com.lyh.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.common.convention.result.BaseResponse;
import com.lyh.shortlink.project.common.convention.result.Result;
import com.lyh.shortlink.project.dto.request.RecycleBinRecoverReqDTO;
import com.lyh.shortlink.project.dto.request.RecycleBinRemoveReqDTO;
import com.lyh.shortlink.project.dto.request.RecycleBinSaveReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkRecycleBinPageReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkPageRespDTO;
import com.lyh.shortlink.project.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 *@title RecycleBinController
 *@description 回收站管理控制层
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 21:24
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {
    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/shortlink/project/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        recycleBinService.saveRecycleBin(requestParam);
        return BaseResponse.success();
    }
    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/shortlink/project/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return BaseResponse.success(recycleBinService.pageShortLink(requestParam));
    }
    /**
     * 恢复短链接
     */
    @PostMapping("/api/shortlink/project/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        recycleBinService.recoverRecycleBin(requestParam);
        return BaseResponse.success();
    }
    /**
     * 移除短链接
     */
    @PostMapping("/api/shortlink/project/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        recycleBinService.removeRecycleBin(requestParam);
        return BaseResponse.success();
    }
}
