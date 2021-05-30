package com.grainoil.system.service;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.rotate.AnnualPlanListVo;
import com.grainoil.system.domain.vo.rotate.dto.AnnualPlanDto;

import java.util.List;

/**
 * @author song
 * @date create in 21/5/20 11:03
 */
public interface ITbAnnualPlanService {

    /**
     * 年度计划列表
     *
     * @param dto 查询条件
     * @return
     */
    List<AnnualPlanListVo> list(AnnualPlanDto dto, String organizeType, Long organizeId, Long lq);

    /**
     * 点击申请按钮时获取标题的前缀
     *
     * @param lq
     * @return
     */
    ResponseResult getPrefix(Long lq);
}
