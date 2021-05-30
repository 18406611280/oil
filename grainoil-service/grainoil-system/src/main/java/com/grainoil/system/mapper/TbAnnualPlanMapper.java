package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbAnnualPlan;
import com.grainoil.system.domain.vo.rotate.AnnualPlanListVo;
import com.grainoil.system.domain.vo.rotate.dto.AnnualPlanDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAnnualPlanMapper {
    int insert(TbAnnualPlan record);

    TbAnnualPlan selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TbAnnualPlan record);

    /**
     * 年度轮换计划列表
     *
     * @param dto
     * @return
     */
    List<AnnualPlanListVo> list(@Param("dto") AnnualPlanDto dto, @Param("organizeType") String organizeType, @Param("organizeId") Long organizeId, @Param("lq") Long lq);
}