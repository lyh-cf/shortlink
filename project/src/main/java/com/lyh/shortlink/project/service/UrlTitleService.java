package com.lyh.shortlink.project.service;

/*
 *@title UrlTitleService
 *@description URL 标题接口层
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 20:32
 */
public interface UrlTitleService {
    /**
     * 根据 URL 获取标题
     *
     * @param url 目标网站地址
     * @return 网站标题
     */
    String getTitleByUrl(String url);
}
