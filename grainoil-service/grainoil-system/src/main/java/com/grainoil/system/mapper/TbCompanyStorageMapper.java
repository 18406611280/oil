package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbCompanyStorage;
import com.grainoil.system.domain.TbGrainDepot;
import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.domain.vo.point_management.OrganizeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbCompanyStorageMapper {

    int updateByPrimaryKey(TbCompanyStorage record);

    /**
     * 添加粮库对应的使用企业
     *
     * @param depot     粮库信息
     * @param companies 使用企业信息
     * @return 结果
     */
    int insertGrainDepot(@Param("depot") TbGrainDepot depot, @Param("companies") Long[] companies);

    /**
     * 统计存储类型对应使用企业的数量
     *
     * @param id   存储id
     * @param type 存储类型
     * @return 结果
     */
    Integer count(@Param("id") Long id, @Param("type") String type);

    /**
     * 判断组织是否使用粮库
     *
     * @param grainDepotId 粮库id
     * @param organizeId   组织id
     * @return 结果
     */
    Integer checkGrainDepotUse(@Param("grainDepotId") Long grainDepotId, @Param("organizeId") Long organizeId);

    /**
     * 根据粮库id获取使用企业信息
     *
     * @param grainDepotId 粮库id
     * @return 使用企业信息集合
     */
    List<OrganizeVo> getUseCompanies(Long grainDepotId);

    /**
     * 根据仓房id获取使用企业信息
     *
     * @param storehouseId 仓房id
     * @return 使用企业信息集合
     */
    List<OrganizeVo> getUseCompanies2(Long storehouseId);

    /**
     * 判断组织是否使用仓房
     *
     * @param id         仓房id
     * @param organizeId 组织id
     * @return 结果
     */
    Integer checkStorehouseUse(@Param("id") Long id, @Param("organizeId") Long organizeId);

    /**
     * 判断组织是否使用堆位
     *
     * @param id
     * @param organizeId
     * @return
     */
    Integer checkPileUse(@Param("id") Long id, @Param("organizeId") Long organizeId);

    /**
     * 获取有实时库存的组织id
     *
     * @param organizeId
     * @return
     */
    List<Long> hasInventory(@Param("organizeId") Long organizeId, @Param("type") String type);

    /**
     * 删除不在集合内的数据
     *
     * @param list
     */
    void deleteNotIn(@Param("list") List<Long> list, @Param("id") Long id, @Param("type") String type, @Param("currentUser") CurrentUser currentUser);

    /**
     * 批量添加
     *
     * @param organizeIds
     * @param storehouseId
     * @param type
     */
    void batchInsert(@Param("organizeIds") List<Long> organizeIds, @Param("storehouseId") Long storehouseId, @Param("type") String type, @Param("currentUser") CurrentUser currentUser);

    /**
     * 仓房所属企业修改时使用企业的添加按钮
     *
     * @param id
     * @param organizeId
     * @return
     */
    List<OrganizeVo> getOrganizeVo(@Param("id") Long id, @Param("organizeId") Long organizeId);

    /**
     * 承储企业使用粮库下拉列表数据
     *
     * @param organizeId 企业组织id
     * @return 粮库下拉列表数据
     */
    List<LeafNode> getGrainDepotList(Long organizeId);

    /**
     * 根据企业id查询使用的粮库id集合
     *
     * @param organizeId 企业id
     * @return 粮库id集合
     */
    List<Long> getGrainDepotIds(Long organizeId);

    /**
     * 存储合同添加时添加存储企业与粮库之间的关系
     *
     * @param organizeId
     * @param longs
     */
    void insertGrainDepot2(@Param("organizeId") Long organizeId, @Param("longs") List<Long> longs, @Param("currentUser") CurrentUser currentUser);
}