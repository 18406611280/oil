package com.grainoil.system.mapper.quality;

import com.grainoil.system.domain.example.TbQualityApplyExample;
import com.grainoil.system.domain.quality.TbQualityApply;
import com.grainoil.system.domain.quality.dto.QualityReportPageDto;
import com.grainoil.system.domain.quality.dto.SampleApplyPageDto;
import com.grainoil.system.domain.quality.dto.SamplePageDto;
import com.grainoil.system.domain.quality.dto.SampleRegisterPageDto;
import com.grainoil.system.domain.vo.quality.QualityReportPageVo;
import com.grainoil.system.domain.vo.quality.SampleQualityApplyPageVo;
import com.grainoil.system.domain.vo.quality.SampleQualityPageVo;
import com.grainoil.system.domain.vo.quality.SampleRegistrationPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbQualityApplyMapper {
    long countByExample(TbQualityApplyExample example);

    int deleteByExample(TbQualityApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbQualityApply record);

    int insertSelective(TbQualityApply record);

    List<TbQualityApply> selectByExample(TbQualityApplyExample example);

    TbQualityApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbQualityApply record, @Param("example") TbQualityApplyExample example);

    int updateByExample(@Param("record") TbQualityApply record, @Param("example") TbQualityApplyExample example);

    int updateByPrimaryKeySelective(TbQualityApply record);

    int updateByPrimaryKey(TbQualityApply record);

    List<SampleQualityApplyPageVo> selectPage(SampleApplyPageDto sampleApplyPageDto);

    List<SampleRegistrationPageVo> selectSamplePage(SampleRegisterPageDto sampleRegisterPageDto);

    List<SampleQualityPageVo> selectQualityPage(@Param("samplePageDto") SamplePageDto samplePageDto, @Param("applyType")String applyType);

    List<QualityReportPageVo> selectQualityReportPage(QualityReportPageDto pageDto);
}