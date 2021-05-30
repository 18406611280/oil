package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbChildPile;
import com.grainoil.system.domain.vo.point_management.PileSplitDto;
import org.apache.ibatis.annotations.Param;

public interface TbChildPileMapper {

    /**
     * 批量添加子堆信息
     *
     * @param splitDto
     * @param currentUser
     */
    void batchInsert(@Param("splitDto") PileSplitDto splitDto, @Param("currentUser") CurrentUser currentUser);

    /**
     * 批量删除子堆信息
     *
     * @param id
     * @param currentUser
     */
    void batchDelete(@Param("id") Long id, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据子堆id查询堆位信息
     *
     * @param childHeapId 子堆id
     * @return
     */
    TbChildPile selectByPrimaryKey(Long childHeapId);
}