package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkBrowserStatsDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkBrowserStatsMapper
 *@description 浏览器统计访问持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/21 22:38
 */
public interface LinkBrowserStatsMapper extends BaseMapper<LinkBrowserStatsDO> {
    /**
     * 记录浏览器访问监控数据
     */
    void shortLinkBrowserState(@Param("linkBrowserStats") LinkBrowserStatsDO linkBrowserStatsDO);
}
