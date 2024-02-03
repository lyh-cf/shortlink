package com.lyh.shortlink.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@title ShortLinkCreateReqDTO
 *@description 短链接创建响应对象
 *@author LYH
 *@version 1.0
 *@create 2024/2/1 17:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortLinkCreateRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 原始链接
     */
    private String originUrl;
    /**
     * 完整短链接
     */
    private String fullShortUrl;

}
