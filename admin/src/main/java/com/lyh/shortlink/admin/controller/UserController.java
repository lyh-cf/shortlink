package com.lyh.shortlink.admin.controller;

import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.dto.response.UserRespDTO;
import com.lyh.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
     * 根据用户名查询用户信息
     */
    @GetMapping(value = "/api/shortlink/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username) {
        return BaseResponse.success(userService.getUserByUserName(username));
    }
}
