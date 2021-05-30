package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.system.domain.quality.dto.DailySampleQualityAddDto;
import com.grainoil.system.domain.quality.dto.SamplePageDto;
import com.grainoil.system.domain.vo.quality.SampleQualityDetailVo;
import com.grainoil.system.domain.vo.quality.SampleQualityPageVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: chenminghong
 * @Date: 2021/5/21 16:28
 */
public interface SampleQualityService {

    PageView<SampleQualityPageVo> page(SamplePageDto samplePageDto, QualityTypeEnum qualityTypeEnum);

    /**
     * 保存日常抽检
     * @param addDto
     * @param currentUser
     */
    @Transactional
    void addDailyQuality(DailySampleQualityAddDto addDto, CurrentUser currentUser);

    /**
     * 获取样品质检详情
     * @param sampleId
     * @return
     */
    SampleQualityDetailVo detail(Long sampleId);

    /**
     * 保存出库质检
     * @param addDto
     * @param currentUser
     */
    void addDeliveryQuality(DailySampleQualityAddDto addDto, CurrentUser currentUser);
}
