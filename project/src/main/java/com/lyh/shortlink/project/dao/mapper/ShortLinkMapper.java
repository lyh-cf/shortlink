package com.lyh.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.project.dao.entity.ShortLinkDO;
import com.lyh.shortlink.project.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.project.dto.request.ShortLinkRecycleBinPageReqDTO;
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
    /**
     * 查询短链接分组内短链接数量
     * @param gids
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO>listGroupShortLinkCount(@Param("gids")List<String> gids);
    /**
     * 短链接访问统计自增
     */
    void incrementStats(
            @Param("gid") String gid,
            @Param("fullShortUrl") String fullShortUrl,
            @Param("totalPv") Integer totalPv,
            @Param("totalUv") Integer totalUv,
            @Param("totalUip") Integer totalUip
    );
    /**
     * 分页查询短链接
     */
    IPage<ShortLinkDO> pageLink(ShortLinkPageReqDTO requestParam);
    /**
     * 分页统计回收站短链接
     */
    IPage<ShortLinkDO> pageRecycleBinLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
