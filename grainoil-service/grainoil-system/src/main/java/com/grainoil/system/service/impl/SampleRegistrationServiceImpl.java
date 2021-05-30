package com.grainoil.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.QualityApplyStatusEnum;
import com.grainoil.common.utils.bean.BeanUtils;
import com.grainoil.system.domain.quality.TbQualityApply;
import com.grainoil.system.domain.quality.TbQualityApplyDetailed;
import com.grainoil.system.domain.quality.dto.RegisterSampleDto;
import com.grainoil.system.domain.quality.dto.SampleRegisterDto;
import com.grainoil.system.domain.quality.dto.SampleRegisterPageDto;
import com.grainoil.system.domain.vo.quality.RegisterSampleVo;
import com.grainoil.system.domain.vo.quality.SampleRegistrationDetailVo;
import com.grainoil.system.domain.vo.quality.SampleRegistrationPageVo;
import com.grainoil.system.mapper.quality.TbQualityApplyDetailedMapper;
import com.grainoil.system.mapper.quality.TbQualityApplyMapper;
import com.grainoil.system.service.SampleRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/20 11:55
 */
@Service
public class SampleRegistrationServiceImpl implements SampleRegistrationService {

    @Autowired
    private TbQualityApplyMapper qualityApplyMapper;

    @Autowired
    private TbQualityApplyDetailedMapper qualityApplyDetailedMapper;

    @Override
    public PageView<SampleRegistrationPageVo> page(SampleRegisterPageDto sampleRegisterPageDto) {
        PageHelper.startPage(sampleRegisterPageDto.getCurrent(), sampleRegisterPageDto.getPageSize());
        List<SampleRegistrationPageVo> list = qualityApplyMapper.selectSamplePage(sampleRegisterPageDto);
        PageInfo<SampleRegistrationPageVo> pageInfo = new PageInfo(list);
        return new PageView(pageInfo);
    }

    @Override
    public SampleRegistrationDetailVo detail(Long applyId) {
        SampleRegistrationDetailVo detailVo = new SampleRegistrationDetailVo();
        TbQualityApply qualityApply = qualityApplyMapper.selectByPrimaryKey(applyId);
        BeanUtils.copyProperties(qualityApply,detailVo);
        List<TbQualityApplyDetailed> tbQualityApplyDetaileds = qualityApplyDetailedMapper.selectByApplyId(qualityApply.getId());
        List<RegisterSampleVo> registerSampleVos = new ArrayList<>();
        for (TbQualityApplyDetailed tbQualityApplyDetailed : tbQualityApplyDetaileds) {
            RegisterSampleVo sampleVo = new RegisterSampleVo();
            BeanUtils.copyProperties(tbQualityApplyDetailed,sampleVo);
            registerSampleVos.add(sampleVo);
        }
        detailVo.setSampleVos(registerSampleVos);
        return detailVo;
    }

    @Override
    @Transactional
    public void register(SampleRegisterDto dto) {
        Long id = dto.getId();
        TbQualityApply qualityApply = qualityApplyMapper.selectByPrimaryKey(id);
        qualityApply.setActualSamplingDate(dto.getActualSamplingDate());
        qualityApply.setSamplers(dto.getSamplers());
        qualityApply.setState(QualityApplyStatusEnum.SAMPLE.code);
        qualityApplyMapper.updateByPrimaryKeySelective(qualityApply);
        List<RegisterSampleDto> sampleDto = dto.getSampleDto();
        for (RegisterSampleDto registerSampleDto : sampleDto) {
            Long sampleId = registerSampleDto.getId();
            TbQualityApplyDetailed tbQualityApplyDetailed = qualityApplyDetailedMapper.selectByPrimaryKey(sampleId);
            tbQualityApplyDetailed.setSampleCode(registerSampleDto.getSampleCode());
            qualityApplyDetailedMapper.updateByPrimaryKeySelective(tbQualityApplyDetailed);
        }
    }
}
