package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.rotate.AnnualPlanListVo;
import com.grainoil.system.domain.vo.rotate.dto.AnnualPlanDto;
import com.grainoil.system.mapper.TbAnnualPlanDepotDetailedMapper;
import com.grainoil.system.mapper.TbAnnualPlanDetailedMapper;
import com.grainoil.system.mapper.TbAnnualPlanMapper;
import com.grainoil.system.mapper.TbOrganizeMapper;
import com.grainoil.system.service.ITbAnnualPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/20 11:04
 */
@Service
public class TbAnnualPlanServiceImpl implements ITbAnnualPlanService {

    @Autowired
    TbAnnualPlanMapper annualPlanMapper;

    @Autowired
    TbAnnualPlanDetailedMapper annualPlanDetailedMapper;

    @Autowired
    TbAnnualPlanDepotDetailedMapper annualPlanDepotDetailedMapper;

    @Autowired
    TbOrganizeMapper organizeMapper;

    /**
     * 年度计划列表
     *
     * @param dto 查询条件
     * @return
     */
    @Override
    public List<AnnualPlanListVo> list(AnnualPlanDto dto, String organizeType, Long organizeId, Long lq) {
        return annualPlanMapper.list(dto, organizeType, organizeId, lq);
    }

    /**
     * 点击申请按钮时获取标题的前缀
     *
     * @param lq
     * @return
     */
    @Override
    public ResponseResult getPrefix(Long lq) {
        int year = Calendar.getInstance().get(Calendar.YEAR) + 1;
        String note = organizeMapper.getNote(lq);
        return ResponseResult.success(year + "年度" + note +"储备粮");
    }
}
