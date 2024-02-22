package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkDeviceStatsDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkDeviceStatsMapper
 *@description 访问设备监控持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 15:19
 */
public interface LinkDeviceStatsMapper extends BaseMapper<LinkDeviceStatsDO> {
    /**
     * 记录访问设备监控数据
     */
    void shortLinkDeviceState(@Param("linkDeviceStats") LinkDeviceStatsDO linkDeviceStatsDO);
}