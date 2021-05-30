package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbGrainDepot;
import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.domain.vo.point_management.GrainDepotInsert;
import com.grainoil.system.domain.vo.point_management.GrainDepotListVo;
import com.grainoil.system.domain.vo.point_management.GrainDepotQueryVo;
import com.grainoil.system.domain.vo.point_management.GrainDepotUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TbGrainDepotMapper {

    /**
     * 添加粮库信息
     *
     * @param record 粮库信息
     * @return 结果
     */
    int insert(@Param("record") GrainDepotInsert record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据id查询粮库信息
     *
     * @param grainDepotId 粮库id
     * @return 粮库信息
     */
    TbGrainDepot selectByPrimaryKey(Long grainDepotId);

    /**
     * 市区修改粮库信息
     *
     * @param record 粮库信息
     * @return 结果
     */
    int updateByPrimaryKey(@Param("record") GrainDepotUpdate record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 添加时统计粮库名称或者粮库编码相同的数据
     */
    Integer count(GrainDepotInsert depot);

    /**
     * 承储企业根据条件查询'我的'和'代储'粮库信息集合
     */
    List<GrainDepotListVo> list(@Param("depot") GrainDepotQueryVo depot, @Param("organizeId") Long organizeId);

    /**
     * 角色为市区粮管中心时粮库列表
     *
     * @param depot      粮库信息
     * @param organizeId 市区组织id
     * @return 粮库列表集合
     */
    List<GrainDepotListVo> select(@Param("depot") GrainDepotQueryVo depot, @Param("organizeId") Long organizeId);

    /**
     * 添加仓房时验证粮库是否存在是否停用
     *
     * @param grainDepotId 粮库id
     * @return 结果
     */
    Integer judge(Long grainDepotId);

    /**
     * 判断粮库id和组织部门id之间的关系
     *
     * @param grainDepotId 粮库id
     * @param organizeId   组织id
     * @return 结果
     */
    Integer getRelation(@Param("grainDepotId") Long grainDepotId, @Param("organizeId") Long organizeId);

    /**
     * 获取所有的粮库下拉框
     *
     * @return 粮库下拉框
     */
    List<Map<String, Object>> getGrainDepots();

    /**
     * 根据id集合验证粮库数量是否正确
     *
     * @param gSet 粮库id集合
     * @return 粮库列表
     */
    List<TbGrainDepot> checkContract(Set<Long> gSet);

    /**
     * 根据粮库id查询粮库所属市(区)粮管中心的组织信息
     *
     * @param ids 粮库id集合
     * @return 结果
     */
    List<Map<String, Object>> getContractRelation(Set<Long> ids);

    /**
     * 添加存储合同添加明细表的添加按钮
     *
     * @param id 粮库id
     * @return 数据列表
     */
    List<Map<String, Object>> getStorageDetailList(@Param("id") Long id);

    /**
     * 承储企业修改粮库信息
     *
     * @param depot 粮库信息
     */
    void update(@Param("depot") GrainDepotUpdate depot, @Param("currentUser") CurrentUser currentUser);

    /**
     * 修改时统计粮库名称或者粮库编码相同的数据
     */
    Integer countUpdate(GrainDepotUpdate depot);

    /**
     * 判断粮库是否属于区粮管下面
     *
     * @param grainDepotId
     * @param organizeId
     * @return
     */
    Integer checkGrainDepotToOrganize(@Param("grainDepotId") Long grainDepotId, @Param("organizeId") Long organizeId);

    /**
     * 市区根据组织id查询所属粮库下拉列表数据
     *
     * @param organizeId 组织id
     * @return 粮库下拉列表数据
     */
    List<LeafNode> getGrainDepotList(Long organizeId);
}