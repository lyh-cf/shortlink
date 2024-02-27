package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkStatsTodayDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkStatsTodayMapper
 *@description 短链接今日统计持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/27 19:14
 */
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {
    /**
     * 记录今日统计监控数据
     */
    void shortLinkTodayState(@Param("linkTodayStats")LinkStatsTodayDO linkStatsTodayDO);
}
