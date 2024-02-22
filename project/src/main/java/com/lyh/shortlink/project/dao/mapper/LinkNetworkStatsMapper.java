package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.LinkNetworkStatsDO;
import org.apache.ibatis.annotations.Param;

/*
 *@title LinkNetworkStatsMapper
 *@description 访问网络监控持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 15:43
 */
public interface LinkNetworkStatsMapper extends BaseMapper<LinkNetworkStatsDO> {
    /**
     * 记录访问设备监控数据
     */
    void shortLinkNetworkState(@Param("linkNetworkStats") LinkNetworkStatsDO linkNetworkStatsDO);
}
