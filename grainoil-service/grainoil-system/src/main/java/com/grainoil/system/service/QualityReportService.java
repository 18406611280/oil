package com.grainoil.system.service;

import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.quality.dto.QualityReportPageDto;
import com.grainoil.system.domain.vo.quality.QualityReportPageVo;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 15:37
 */
public interface QualityReportService {
    PageView<QualityReportPageVo> page(QualityReportPageDto dto);
}
