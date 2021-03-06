package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbGrainActualInventory;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.TbInWarehouseDetailed;
import com.grainoil.system.domain.example.TbGrainActualInventoryExample;
import com.grainoil.system.domain.vo.GrainDepVo;
import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.domain.vo.common.SecondNode;
import com.grainoil.system.domain.vo.common.ThirdNode;
import com.grainoil.system.domain.vo.rotate.InsertListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbGrainActualInventoryMapper {
    long countByExample(TbGrainActualInventoryExample example);

    int deleteByExample(TbGrainActualInventoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbGrainActualInventory record);

    int insertSelective(TbGrainActualInventory record);

    List<TbGrainActualInventory> selectByExample(TbGrainActualInventoryExample example);

    TbGrainActualInventory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGrainActualInventory record, @Param("example") TbGrainActualInventoryExample example);

    int updateByExample(@Param("record") TbGrainActualInventory record, @Param("example") TbGrainActualInventoryExample example);

    int updateByPrimaryKeySelective(TbGrainActualInventory record);

    int updateByPrimaryKey(TbGrainActualInventory record);

    @Select("select * from tb_grain_actual_inventory where organize_id = #{organizeId} and grain_owner_id = #{lq} and grain_depot_id = #{grainDepotId}")
    List<TbGrainActualInventory> getSampleInventory(@Param("organizeId") Long organizeId, @Param("lq")Long lq, @Param("grainDepotId")Long grainDepotId);

    @Select("select grain_depot_id as grainDepotId,grain_depot_name as grainDepotName from tb_grain_actual_inventory where organize_id = #{organizeId} and grain_owner_id = #{lq}")
    List<GrainDepVo> selectGrainDepot(@Param("organizeId") Long organizeId, @Param("lq")Long lq);

    /**
     * ????????????id????????????????????????
     *
     * @param id
     * @return
     */
    @Select("SELECT count(1) FROM tb_grain_actual_inventory WHERE del_flag = '0' AND heap_id = #{id}")
    Integer countByPileId(Long id);

    @Select("select * from tb_grain_actual_inventory where organize_id = #{organizeId} and grain_owner_id = #{lq} " +
            "and grain_depot_id = #{grainDepotId} and storehouse_id = #{storehouseId} and heap_id = #{heapId}")
    List<TbGrainActualInventory> getInventory(@Param("organizeId") Long organizeId, @Param("lq")Long lq, @Param("grainDepotId")Long grainDepotId, @Param("storehouseId")Long storehouseId, @Param("heapId")Long heapId);

    /**
     * ???/????????????????????????
     *
     * @param organizeId
     * @return
     */
    List<LeafNode> getOrganizeList(Long organizeId);

    /**
     * ???????????????????????????
     *
     * @param organizeId
     * @return
     */
    List<LeafNode> getCompanyList(Long organizeId);

    /**
     * ???/???????????????-???????????????
     *
     * @param organizeId
     * @return
     */
    List<SecondNode> getOrganizeList2(Long organizeId);

    /**
     * ??????????????????-???????????????
     *
     * @param organizeId
     * @return
     */
    List<SecondNode> getCompanyList2(Long organizeId);

    /**
     * ???/???????????????-??????-???????????????
     *
     * @param organizeId
     * @return
     */
    List<ThirdNode> getOrganizeList3(Long organizeId);

    /**
     * ??????????????????-??????-???????????????
     *
     * @param organizeId
     * @return
     */
    List<ThirdNode> getCompanyList3(Long organizeId);

    /**
     * ??????????????????????????????????????????
     *
     * @param organizeId
     * @return
     */
    List<InsertListVo> getInsert(Long organizeId);

    /**
     * ????????????????????????????????????????????????
     *
     * @param tbInWarehouse
     * @param ids
     */
    void batchInsert(TbInWarehouse tbInWarehouse, List<TbInWarehouseDetailed> ids);
}