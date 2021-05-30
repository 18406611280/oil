package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.vo.quality.FoodStuffCheckVo;
import com.grainoil.system.domain.vo.quality.VarietyCheckVo;

import java.util.List;

public interface ITbFoodStuffCheckService {

    FoodStuffCheckVo get(Long varietyId, CurrentUser currentUser);

    void update(FoodStuffCheckVo foodStuffCheckVo, CurrentUser organizeId);

    List<VarietyCheckVo> queryVariety();
}
