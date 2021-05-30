package com.grainoil.system.mapper.quality;

import com.grainoil.system.domain.quality.FoodStuffCheck;
import com.grainoil.system.domain.vo.quality.FoodCheckVo;
import com.grainoil.system.domain.vo.quality.VarietyCheckVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FoodStuffCheckMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FoodStuffCheck record);

    int insertSelective(FoodStuffCheck record);

    FoodStuffCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoodStuffCheck record);

    int updateByPrimaryKey(FoodStuffCheck record);

    @Delete("delete from tb_foodstuff_check_item where variety_id = #{varietyId}")
    int deleteByVarietyId(@Param("varietyId")Long varietyId);

    @Select("select * from tb_foodstuff_check_item where variety_id = #{varietyId} and apply_type = '0'")
    List<FoodCheckVo> getByQuality(@Param("varietyId")Long varietyId);

    @Select("select * from tb_foodstuff_check_item where variety_id = #{varietyId} and organize_id = #{organizeId} or (apply_type = '0' and variety_id = #{varietyId})")
    List<FoodCheckVo> getByOrganize(@Param("varietyId") Long varietyId, @Param("organizeId")Long organizeId);

    List<VarietyCheckVo> queryVariety();

    @Select("select * from tb_foodstuff_check_item where variety_id = #{varietyId}")
    List<FoodStuffCheck> selectByVarietyId(@Param("varietyId")Long varietyId);
}