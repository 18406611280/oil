package com.grainoil.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.quality.dto.QualityReportPageDto;
import com.grainoil.system.domain.vo.quality.QualityReportPageVo;
import com.grainoil.system.domain.vo.quality.SampleRegistrationPageVo;
import com.grainoil.system.mapper.quality.TbQualityApplyMapper;
import com.grainoil.system.service.QualityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 15:37
 */
@Service
public class QualityReportServiceImpl implements QualityReportService {

    @Autowired
    private TbQualityApplyMapper qualityApplyMapper;

    @Override
    public PageView<QualityReportPageVo> page(QualityReportPageDto pageDto) {
        PageHelper.startPage(pageDto.getCurrent(), pageDto.getPageSize());
        List<QualityReportPageVo> list = qualityApplyMapper.selectQualityReportPage(pageDto);
        PageInfo<SampleRegistrationPageVo> pageInfo = new PageInfo(list);
        return new PageView(pageInfo);
    }
}
