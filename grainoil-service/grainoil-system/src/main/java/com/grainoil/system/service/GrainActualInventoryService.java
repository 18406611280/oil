package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.quality.dto.InventoryDto;
import com.grainoil.system.domain.vo.quality.GrainInventoryVo;
import com.grainoil.system.domain.vo.quality.SampleInventoryVo;
import com.grainoil.system.domain.vo.rotate.InsertListVo;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 15:03
 */
public interface GrainActualInventoryService {

    List<SampleInventoryVo> getSampleInventory(Long grainDepotId, CurrentUser currentUser);

    GrainInventoryVo getInventory(InventoryDto inventoryDto, CurrentUser currentUser);
    /**
     * 申请年度计划时添加按钮的列表
     *
     * @param organizeId
     * @return
     */
    List<InsertListVo> getInsert(Long organizeId);

}
