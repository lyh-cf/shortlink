package com.lyh.shortlink.admin.controller;

import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSaveReqDTO;
import com.lyh.shortlink.admin.dto.response.ShortLinkGroupRespDTO;
import com.lyh.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@title GroupController
 *@description 短链接分组控制层
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 21:31
 */
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    /**
     * 短链接分组新增
     */
    @PostMapping(value = "/api/shortlink/group")
    public Result<Void>save(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam);
        return BaseResponse.success();
    }
    /**
     * 短链接分组新增
     */
    @GetMapping(value = "/api/shortlink/getShortLinkGroupList")
    public Result<List<ShortLinkGroupRespDTO>>getShortLinkGroupList(){
        groupService.getShortLinkGroupList();
        return BaseResponse.success(null);
    }
}
