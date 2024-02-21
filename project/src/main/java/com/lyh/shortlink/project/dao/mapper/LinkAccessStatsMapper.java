package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkAccessStatsDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkAccessStatsMapper
 *@description 短链接基础访问监控持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/20 20:27
 */
public interface LinkAccessStatsMapper extends BaseMapper<LinkAccessStatsDO> {
    /**
     * 记录基础访问监控数据
     */
    void shortLinkStats(@Param("linkAccessStats") LinkAccessStatsDO linkAccessStatsDO);
}
