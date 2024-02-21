package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkLocaleStatsDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkLocaleStatsMapper
 *@description 地区统计访问持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/21 16:26
 */
public interface LinkLocaleStatsMapper extends BaseMapper<LinkLocaleStatsDO> {
    /**
     * 记录地区访问监控数据
     */
    void shortLinkLocaleState(@Param("linkLocaleStats") LinkLocaleStatsDO linkLocaleStatsDO);
}
