package com.lyh.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.shortlink.project.dao.entity.ShortLinkDO;
import com.lyh.shortlink.project.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkCreateRespDTO;

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
}
