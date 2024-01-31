package com.lyh.shortlink.admin.dto.request;

import lombok.Data;

/*
 *@title ShortLinkGroupSaveReqDTO
 *@description 短链接分组排序参数
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 22:06
 */
@Data
public class ShortLinkGroupSortReqDTO {
    /**
     * 分组标识
     */
    private String gid;
    /**
     * 排序
     */
    private Integer sortOrder;
}
