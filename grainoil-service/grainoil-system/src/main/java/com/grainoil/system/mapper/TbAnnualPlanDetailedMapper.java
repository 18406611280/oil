package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbAnnualPlanDetailed;

public interface TbAnnualPlanDetailedMapper {
    int insert(TbAnnualPlanDetailed record);

    TbAnnualPlanDetailed selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TbAnnualPlanDetailed record);
}