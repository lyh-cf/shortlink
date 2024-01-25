package com.lyh.shortlink.admin.controller;

import com.lyh.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
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
}
