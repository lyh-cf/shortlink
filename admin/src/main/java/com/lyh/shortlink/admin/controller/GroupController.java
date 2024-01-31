package com.lyh.shortlink.admin.controller;

import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSaveReqDTO;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupSortReqDTO;
import com.lyh.shortlink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import com.lyh.shortlink.admin.dto.response.ShortLinkGroupRespDTO;
import com.lyh.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
     * 查询短链接分组
     */
    @GetMapping(value = "/api/shortlink/getShortLinkGroupList")
    public Result<List<ShortLinkGroupRespDTO>>getShortLinkGroupList(){
        List<ShortLinkGroupRespDTO> shortLinkGroupList = groupService.getShortLinkGroupList();
        return BaseResponse.success(shortLinkGroupList);
    }
    /**
     * 修改短链接分组名
     */
    @PutMapping(value = "/api/shortlink/group")
    public Result<Void>updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam){
        groupService.updateGroup(requestParam);
        return BaseResponse.success();
    }
    /**
     * 删除短链接分组
     */
    @DeleteMapping(value = "/api/shortlink/group/{gid}")
    public Result<Void>deleteGroup(@PathVariable("gid") String gid){
        groupService.deleteGroup(gid);
        return BaseResponse.success();
    }
    /**
     * 短链接分组排序
     */
    @PostMapping(value = "/api/shortlink/group/sort")
    public Result<Void>sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO>requestParam){
        groupService.sortGroup(requestParam);
        return BaseResponse.success();
    }
}
