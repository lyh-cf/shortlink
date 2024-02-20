package com.lyh.shortlink.project.controller;

import com.lyh.shortlink.project.common.convention.result.BaseResponse;
import com.lyh.shortlink.project.common.convention.result.Result;
import com.lyh.shortlink.project.service.UrlTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *@title UrlTitleController
 *@description URL 标题控制层
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 20:31
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    private final UrlTitleService urlTitleService;

    /**
     * 根据 URL 获取对应网站的标题
     */
    @GetMapping("/api/shortlink/project/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return BaseResponse.success(urlTitleService.getTitleByUrl(url));
    }
}
