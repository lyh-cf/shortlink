package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkOsStatsDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkOsStatsMapper
 *@description 操作系统统计访问持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/21 22:23
 */
public interface LinkOsStatsMapper extends BaseMapper<LinkOsStatsDO> {
    /**
     * 记录操作系统访问监控数据
     */
    void shortLinkOsState(@Param("linkOsStats") LinkOsStatsDO linkOsStatsDO);
}
