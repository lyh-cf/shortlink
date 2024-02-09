package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.shortlink.project.dao.entity.ShortLinkDO;
import com.lyh.shortlink.project.dto.response.ShortLinkGroupCountQueryRespDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@title LinkMapper
 *@description 短链接持久层
 *@author LYH
 *@version 1.0
 *@create 2024/2/1 16:48
 */
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {
    List<ShortLinkGroupCountQueryRespDTO>listGroupShortLinkCount(@Param("gids")List<String> gids);
}
