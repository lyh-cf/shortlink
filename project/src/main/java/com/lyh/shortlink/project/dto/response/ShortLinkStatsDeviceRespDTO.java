package com.lyh.shortlink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@title ShortLinkStatsDeviceRespDTO
 *@description 短链接访问设备监控响应参数
 *@author LYH
 *@version 1.0
 *@create 2024/2/22 21:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsDeviceRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 设备类型
     */
    private String device;

    /**
     * 占比
     */
    private Double ratio;
}
