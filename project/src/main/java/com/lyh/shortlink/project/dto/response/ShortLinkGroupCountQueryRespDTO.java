package com.lyh.shortlink.project.dto.response;

import lombok.Data;

/*
 *@title ShortLinkCountQueryReqDTO
 *@description 短链接分组查询响应实体
 *@author LYH
 *@version 1.0
 *@create 2024/2/8 13:28
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {
    /**
     * 分组标识
     */
    private String gid;
    /**
     * 短链接数量
     */
    private Integer shortLinkCount;
}
