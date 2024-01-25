package com.lyh.shortlink.admin.controller;

import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSaveReqDTO;
import com.lyh.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/api/shortlink/group")
    public Result<Void>save(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam);
        return BaseResponse.success();
    }

}
