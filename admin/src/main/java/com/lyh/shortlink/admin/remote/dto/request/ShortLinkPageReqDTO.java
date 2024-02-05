package com.lyh.shortlink.admin.remote.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/*
 *@title ShortLinkPageReqDTO
 *@description 短链接分页查询请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/2/4 20:14
 */
@Data
public class ShortLinkPageReqDTO extends Page{
    /**
     * 分组标识
     */
    private String gid;
}
