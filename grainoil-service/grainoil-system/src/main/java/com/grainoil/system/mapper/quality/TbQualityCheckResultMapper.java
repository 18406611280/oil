package com.grainoil.system.mapper.quality;

import com.grainoil.system.domain.example.TbQualityCheckResultExample;
import com.grainoil.system.domain.quality.TbQualityCheckResult;
import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbQualityCheckResultMapper {
    long countByExample(TbQualityCheckResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbQualityCheckResult record);

    int insertSelective(TbQualityCheckResult record);

    List<TbQualityCheckResult> selectByExample(TbQualityCheckResultExample example);

    TbQualityCheckResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbQualityCheckResult record, @Param("example") TbQualityCheckResultExample example);

    int updateByExample(@Param("record") TbQualityCheckResult record, @Param("example") TbQualityCheckResultExample example);

    int updateByPrimaryKeySelective(TbQualityCheckResult record);

    int updateByPrimaryKey(TbQualityCheckResult record);

    void batchInsert(@Param("items") List<TbQualityCheckResult> items);

    @Select("select r.quality_check_result AS checkResult, c.term_name AS termName, c.standard from tb_quality_check_result r " +
            "LEFT JOIN tb_foodstuff_check_item c ON r.quality_check_id = c.id where quality_apply_detailed_id = #{applyDetailId}")
    List<FoodCheckItemVo> selectCheckResult(@Param("applyDetailId") Long applyDetailId);
}