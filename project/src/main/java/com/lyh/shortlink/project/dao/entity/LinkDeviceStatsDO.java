package com.lyh.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyh.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 *@title LinkDeviceStatsDO
 *@description 访问设备统计访问实体
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 15:05
 */
@Data
@TableName("t_link_device_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkDeviceStatsDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 日期
     */
    private Date date;

    /**
     * 访问量
     */
    private Integer cnt;

    /**
     * 访问设备
     */
    private String device;
}
