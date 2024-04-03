package com.lyh.shortlink.admin.remote.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/*
 *@title ShortLinkStatsAccessRecordReqDTO
 *@description 短链接监控访问记录请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/4/3 16:19
 */
@Data
public class ShortLinkStatsAccessRecordReqDTO extends Page {

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
