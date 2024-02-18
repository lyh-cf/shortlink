package com.lyh.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@title ShortLinkGoToDO
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/2/14 14:40
 */
@Data
@TableName("t_link_goto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortLinkGoToDO {
    /**
     * id
     */
    private Long id;
    /**
     * 分组标识
     */
    private String gid;
    /**
     * 完整短链接
     */
    private String fullShortUrl;
}
