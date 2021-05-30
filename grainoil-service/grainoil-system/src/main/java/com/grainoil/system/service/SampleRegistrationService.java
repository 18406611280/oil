package com.grainoil.system.service;

import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.quality.dto.SampleRegisterDto;
import com.grainoil.system.domain.quality.dto.SampleRegisterPageDto;
import com.grainoil.system.domain.vo.quality.SampleRegistrationDetailVo;
import com.grainoil.system.domain.vo.quality.SampleRegistrationPageVo;

/**
 * @Author: chenminghong
 * @Date: 2021/5/20 11:54
 */
public interface SampleRegistrationService {
    PageView<SampleRegistrationPageVo> page(SampleRegisterPageDto dto);

    SampleRegistrationDetailVo detail(Long applyId);

    void register(SampleRegisterDto dto);
}
