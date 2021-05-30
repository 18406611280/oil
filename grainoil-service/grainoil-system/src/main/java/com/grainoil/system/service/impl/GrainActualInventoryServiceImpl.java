package com.grainoil.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.utils.DateUtils;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.common.utils.bean.BeanUtils;
import com.grainoil.system.domain.TbGrainActualInventory;
import com.grainoil.system.domain.quality.FoodStuffCheck;
import com.grainoil.system.domain.quality.dto.InventoryDto;
import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import com.grainoil.system.domain.vo.quality.GrainInventoryVo;
import com.grainoil.system.domain.vo.quality.SampleInventoryVo;
import com.grainoil.system.domain.vo.rotate.InsertListVo;
import com.grainoil.system.mapper.TbGrainActualInventoryMapper;
import com.grainoil.system.mapper.quality.FoodStuffCheckMapper;
import com.grainoil.system.service.GrainActualInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 15:03
 */
@Service
public class GrainActualInventoryServiceImpl implements GrainActualInventoryService {

    @Autowired
    private TbGrainActualInventoryMapper tbGrainActualInventoryMapper;

    @Autowired
    private FoodStuffCheckMapper foodStuffCheckMapper;


    @Override
    public List<SampleInventoryVo> getSampleInventory(Long grainDepotId, CurrentUser currentUser) {
        Long organizeId = currentUser.getOrganizeId();
        Long lq = currentUser.getLq();
        List<TbGrainActualInventory> sampleInventory = tbGrainActualInventoryMapper.getSampleInventory(organizeId, lq, grainDepotId);
        List<SampleInventoryVo> sampleInventoryVoList = new ArrayList<>();
        for (TbGrainActualInventory tbGrainActualInventory : sampleInventory) {
            SampleInventoryVo sampleInventoryVo = new SampleInventoryVo();
            BeanUtils.copyProperties(tbGrainActualInventory,sampleInventoryVo);
            Date warehouseStartDate = tbGrainActualInventory.getWarehouseStartDate();
            Date warehouseEndDate = tbGrainActualInventory.getWarehouseEndDate();
            String startDate = DateUtils.parseDateToStr("yyyy-MM-dd",warehouseStartDate);
            String endDate = DateUtils.parseDateToStr("yyyy-MM-dd",warehouseEndDate);
            sampleInventoryVo.setWarehouseDate(startDate+"~"+endDate);
            String heapName = tbGrainActualInventory.getHeapName();
            String childHeapCode = tbGrainActualInventory.getChildHeapCode();
            if(StringUtils.isNotBlank(childHeapCode)){
                sampleInventoryVo.setHeapName(childHeapCode);
            }else{
                sampleInventoryVo.setHeapName(heapName);
            }
            sampleInventoryVoList.add(sampleInventoryVo);
        }
        return sampleInventoryVoList;
    }

    @Override
    public GrainInventoryVo getInventory(InventoryDto inventoryDto, CurrentUser currentUser) {
        Long organizeId = currentUser.getOrganizeId();
        Long lq = currentUser.getLq();
        Long grainDepotId = inventoryDto.getGrainDepotId();
        Long storehouseId = inventoryDto.getStorehouseId();
        Long heapId = inventoryDto.getHeapId();
        List<TbGrainActualInventory> sampleInventorys = tbGrainActualInventoryMapper.getInventory(organizeId, lq, grainDepotId,storehouseId,heapId);
        if(CollectionUtil.isEmpty(sampleInventorys)) return null;
        TbGrainActualInventory grainActualInventory;
        if(sampleInventorys.size() == 1){
            grainActualInventory = sampleInventorys.get(0);
        }else{
            Long childHeapId = inventoryDto.getChildHeapId();
            List<TbGrainActualInventory> collect = sampleInventorys.stream().filter(a -> a.getChildHeapId() == childHeapId).collect(Collectors.toList());
            grainActualInventory = CollectionUtil.isEmpty(collect) ? null : collect.get(0);
            if(grainActualInventory == null) return null;
        }
        GrainInventoryVo grainInventoryVo = new GrainInventoryVo();
        BeanUtils.copyProperties(grainActualInventory,grainInventoryVo);
        Date warehouseStartDate = grainActualInventory.getWarehouseStartDate();
        Date warehouseEndDate = grainActualInventory.getWarehouseEndDate();
        String startDate = DateUtils.parseDateToStr("yyyy-MM-dd",warehouseStartDate);
        String endDate = DateUtils.parseDateToStr("yyyy-MM-dd",warehouseEndDate);
        grainInventoryVo.setWarehouseDate(startDate+"~"+endDate);
        grainInventoryVo.setInventoryId(grainActualInventory.getId());
        Long varietyId = grainActualInventory.getVarietyId();
        List<FoodStuffCheck> foodStuffCheck = foodStuffCheckMapper.selectByVarietyId(varietyId);
        List<FoodCheckItemVo> list = new ArrayList<>();
        for (FoodStuffCheck check : foodStuffCheck) {
            FoodCheckItemVo itemVo = new FoodCheckItemVo();
            BeanUtils.copyProperties(check,itemVo);
            itemVo.setCheckItemId(check.getId());
            list.add(itemVo);
        }
        grainInventoryVo.setFoodCheckItemVos(list);
        return grainInventoryVo;
    }

    /**
     * 申请年度计划时添加按钮的列表
     *
     * @param organizeId
     * @return
     */
    @Override
    public List<InsertListVo> getInsert(Long organizeId) {
        return tbGrainActualInventoryMapper.getInsert(organizeId);
    }

}
