package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbPileProperty;
import com.grainoil.system.domain.vo.point_management.PileSplitDto;
import com.grainoil.system.domain.vo.point_management.PileVo;
import org.apache.ibatis.annotations.Param;

public interface TbPilePropertyMapper {

    /**
     * 添加堆位属性
     *
     * @param record
     * @param currentUser
     */
    void insert(@Param("record") TbPileProperty record, @Param("currentUser") CurrentUser currentUser);

    TbPileProperty selectByPrimaryKey(Long pileId);

    /**
     * 修改堆位属性
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(@Param("record") PileVo record, @Param("currentUser") CurrentUser currentUser);
}