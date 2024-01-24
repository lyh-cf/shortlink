package com.lyh.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.dto.request.UserRegisterReqDTO;
import com.lyh.shortlink.admin.dto.response.UserActualRespDTO;
import com.lyh.shortlink.admin.dto.response.UserRespDTO;
import com.lyh.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
 *@title UserController
 *@description 用户管理控制层
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 21:36
 */
@RestController
//Spring 官方推荐使用构造器注入方式,配合lombok
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 根据用户名查询用户脱敏信息
     */
    @GetMapping(value = "/api/shortlink/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username) {
        return BaseResponse.success(userService.getUserByUserName(username));
    }
    /**
     * 根据用户名查询用户真实信息
     */
    @GetMapping(value = "/api/shortlink/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUserName(@PathVariable("username") String username) {
        return BaseResponse.success(BeanUtil.toBean(userService.getUserByUserName(username),UserActualRespDTO.class));
    }
    /**
     * 查询用户名是否存在
     */
    @GetMapping(value = "/api/shortlink/user/has-username/{username}")
    public Result<Boolean>hasUserName(@PathVariable("username") String username){
        return BaseResponse.success(userService.hasUserName(username));
    }
    /**
     * 用户注册
     */
    @PostMapping(value = "/api/shortlink/user")
    public Result<Void>register(@RequestBody UserRegisterReqDTO requestParam){
        userService.register(requestParam);
        return BaseResponse.success();
    }
}
