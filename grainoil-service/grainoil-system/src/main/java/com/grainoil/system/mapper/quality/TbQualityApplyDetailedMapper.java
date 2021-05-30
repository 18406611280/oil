package com.grainoil.system.mapper.quality;

import com.grainoil.system.domain.example.TbQualityApplyDetailedExample;
import com.grainoil.system.domain.quality.TbQualityApplyDetailed;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbQualityApplyDetailedMapper {
    long countByExample(TbQualityApplyDetailedExample example);

    int deleteByExample(TbQualityApplyDetailedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbQualityApplyDetailed record);

    int insertSelective(TbQualityApplyDetailed record);

    List<TbQualityApplyDetailed> selectByExample(TbQualityApplyDetailedExample example);

    TbQualityApplyDetailed selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbQualityApplyDetailed record, @Param("example") TbQualityApplyDetailedExample example);

    int updateByExample(@Param("record") TbQualityApplyDetailed record, @Param("example") TbQualityApplyDetailedExample example);

    int updateByPrimaryKeySelective(TbQualityApplyDetailed record);

    int updateByPrimaryKey(TbQualityApplyDetailed record);

    @Select("select * from tb_quality_apply_detailed where apply_id =  #{applyId}")
    List<TbQualityApplyDetailed> selectByApplyId(Long applyId);
}