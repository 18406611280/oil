package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.system.domain.TbVariety;
import com.grainoil.system.domain.quality.FoodStuffCheck;
import com.grainoil.system.domain.vo.quality.FoodCheckVo;
import com.grainoil.system.domain.vo.quality.FoodStuffCheckVo;
import com.grainoil.system.domain.vo.quality.VarietyCheckVo;
import com.grainoil.system.mapper.TbVarietyMapper;
import com.grainoil.system.mapper.quality.FoodStuffCheckMapper;
import com.grainoil.system.service.ITbFoodStuffCheckService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ITbFoodStuffCheckServiceImpl implements ITbFoodStuffCheckService {

    @Autowired
    private FoodStuffCheckMapper foodStuffCheckMapper;

    @Autowired
    private TbVarietyMapper varietyMapper;

    @Override
    public List<VarietyCheckVo> queryVariety() {
        return foodStuffCheckMapper.queryVariety();
    }

    @Override
    public FoodStuffCheckVo get(Long varietyId, CurrentUser currentUser) {
        Long organizeId = currentUser.getOrganizeId();
        String organizeType = currentUser.getOrganizeType();
        TbVariety tbVariety = varietyMapper.selectByPrimaryKey(varietyId);
        FoodStuffCheckVo vo = new FoodStuffCheckVo();
        vo.setVarietyId(tbVariety.getVarietyId());
        vo.setVariety(tbVariety.getVarietyName());
        //质检人只查type为0的
        if(organizeType == OrganizeTypeEnum.QUALITY.code){
            List<FoodCheckVo> foodCheckVoList = foodStuffCheckMapper.getByQuality(varietyId);
            vo.setFoodCheckVoList(foodCheckVoList);
            return vo;
        }
        List<FoodCheckVo> checkVoList = foodStuffCheckMapper.getByOrganize(varietyId,organizeId);
        vo.setFoodCheckVoList(checkVoList);
        return vo;

    }

    @Override
    @Transactional
    public void update(FoodStuffCheckVo foodStuffCheckVo, CurrentUser currentUser) {
        List<FoodCheckVo> foodCheckVoList = foodStuffCheckVo.getFoodCheckVoList();
        Long varietyId = foodStuffCheckVo.getVarietyId();
        String variety = foodStuffCheckVo.getVariety();
        foodStuffCheckMapper.deleteByVarietyId(varietyId);
        for (FoodCheckVo foodCheckVo : foodCheckVoList) {
            FoodStuffCheck foodStuffCheck = new FoodStuffCheck();
            BeanUtils.copyProperties(foodCheckVo,foodStuffCheck);
            foodStuffCheck.setCreateId(currentUser.getCurrentId());
            foodStuffCheck.setCreateBy(currentUser.getCurrentName());
            foodStuffCheck.setUpdateBy(currentUser.getCurrentName());
            foodStuffCheck.setUpdateId(currentUser.getCurrentId());
            foodStuffCheck.setVarietyId(varietyId);
            foodStuffCheck.setVariety(variety);
            //存储企业人员
            if(currentUser.getOrganizeType() == OrganizeTypeEnum.COMPANY.code){
                foodStuffCheck.setOrganizeId(currentUser.getOrganizeId());
                foodStuffCheck.setApplyType(QualityTypeEnum.OUT.code);
            }else{
                foodStuffCheck.setApplyType(QualityTypeEnum.ALL.code);
            }
            foodStuffCheck.setApplyType("3");
            foodStuffCheckMapper.insert(foodStuffCheck);
        }
    }

}
