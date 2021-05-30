package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.system.domain.quality.TbQualityApply;
import com.grainoil.system.domain.quality.TbQualityApplyDetailed;
import com.grainoil.system.domain.quality.dto.SampleApplyDto;
import com.grainoil.system.domain.quality.dto.SampleApplyEditDto;
import com.grainoil.system.domain.quality.dto.SampleApplyPageDto;
import com.grainoil.system.domain.quality.dto.SampleDto;
import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import com.grainoil.system.domain.vo.quality.QualityApplyDetailVo;
import com.grainoil.system.domain.vo.quality.SampleInformationVo;
import com.grainoil.system.domain.vo.quality.SampleQualityApplyPageVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/14 11:27
 */
public interface SampleApplicationService {
    SampleInformationVo getSampleInformation(CurrentUser currentUser);

    /**
     * 保存质检样品明细变（通用）
     * @param apply
     * @param sampleDto
     * @return
     */
    @Transactional
    TbQualityApplyDetailed saveQualityApplyDetail(TbQualityApply apply, SampleDto sampleDto);

    PageView<SampleQualityApplyPageVo> page(SampleApplyPageDto sampleApplyPageDto);

    QualityApplyDetailVo getApplyDetail(Long id);

    void editApply(SampleApplyEditDto applyEditDto);

    /**
     * 保存质检申请表（通用）
     * @param sampleApplyDto
     * @param currentUser
     * @param typeEnum 申请类型
     * @param status 申请状态
     * @return
     */
    @Transactional
    TbQualityApply saveQualityApply(SampleApplyDto sampleApplyDto, CurrentUser currentUser, QualityTypeEnum typeEnum, String status);

    /**
     * 保存质检结果
     * @param applyDetailedId
     * @param foodCheckItemVos
     */
    void saveCheckResult(Long applyDetailedId, List<FoodCheckItemVo> foodCheckItemVos);

    /**
     * 申请接收
     * @param applyId
     */
    void receive(Long applyId);
}
