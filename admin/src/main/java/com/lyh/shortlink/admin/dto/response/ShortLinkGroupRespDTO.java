package com.lyh.shortlink.admin.dto.response;

import lombok.Data;

/*
 *@title ShortLinkGroupRespDTO
 *@description 短链接分组返回实体
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 22:30
 */
@Data
public class ShortLinkGroupRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 分组排序
     */
    private Integer sortOrder;
}
