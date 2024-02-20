package com.lyh.shortlink.project.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyh.shortlink.project.dao.entity.ShortLinkDO;
import lombok.Data;

import java.util.List;

/*
 *@title ShortLinkRecycleBinPageReqDTO
 *@description 回收站短链接分页请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/2/20 11:10
 */
@Data
public class ShortLinkRecycleBinPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private List<String> gidList;
}
