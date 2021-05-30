package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbAnnualPlanDepotDetailed;

public interface TbAnnualPlanDepotDetailedMapper {
    int insert(TbAnnualPlanDepotDetailed record);

    TbAnnualPlanDepotDetailed selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TbAnnualPlanDepotDetailed record);
}