package com.lyh.shortlink.admin.dto.request;

import lombok.Data;

/*
 *@title ShortLinkGroupSaveReqDTO
 *@description 短链接分组创建参数
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 22:06
 */
@Data
public class ShortLinkGroupSaveReqDTO {
    /**
     * 分组名称
     */
    private String name;
}
