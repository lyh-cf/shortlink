package com.lyh.shortlink.project.controller;

/*
 *@title ShortLinkNotFoundController
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 19:19
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 短链接不存在跳转控制器
 */
//返回视图，@RestController返回json形式
@Controller
public class ShortLinkNotFoundController {

    /**
     * 短链接不存在跳转页面
     */
    @RequestMapping("/page/notfound")
    public String notfound() {
        return "notfound";
    }
}