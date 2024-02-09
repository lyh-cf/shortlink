package com.lyh.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.shortlink.project.dao.entity.ShortLinkDO;
import com.lyh.shortlink.project.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkGroupCountQueryRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkPageRespDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkCreateRespDTO;

import java.util.List;

/*
 *@title ShortLinkService
 *@description 短链接接口层
 *@author LYH
 *@version 1.0
 *@create 2024/2/1 17:02
 */
public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * 创建短链接
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);
    /**
     * 分页查询短链接
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);
    /**
     * 查询短链接分组内短链接数量
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);
}
