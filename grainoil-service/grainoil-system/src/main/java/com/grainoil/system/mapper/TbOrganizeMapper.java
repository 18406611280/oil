package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbGrainDepot;
import com.grainoil.system.domain.TbOrganize;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbOrganizeMapper {

    /**
     * 添加组织信息
     *
     * @param organize 组织信息
     * @return number
     */
    int insert(TbOrganize organize);

    /**
     * 根据id获取组织信息
     *
     * @param organizeId 组织id
     * @return 组织信息
     */
    TbOrganize selectByPrimaryKey(Long organizeId);

    /**
     * 修改组织信息
     *
     * @param organize 组织信息
     * @return number
     */
    int updateByPrimaryKey(TbOrganize organize);

    /**
     * 根据条件分页查询组织信息列表
     *
     * @param organize 组织信息
     * @return 组织信息集合
     */
    List<TbOrganize> list(TbOrganize organize);

    /**
     * 获取组织管理树
     *
     * @return 组织管理树结构
     */
    List<TbOrganize> getTree(@Param("organizeId") String organizeId);

    String selectTypeById(Long organizeId);

    /**
     * 根据组织id查询组织类型
     *
     * @param id 组织id
     * @return 组织类型
     */
    String getTypeById(Long id);

    /**
     * 获取父节点组织的父节点id集合
     *
     * @param parentId 父节点id
     * @return 集合信息
     */
    Map<String, Object> getParents(Long parentId);

    /**
     * 验证粮库信息中组织id和组织名称是否对应
     *
     * @param depot 粮库信息
     * @return 结果
     */
    Integer checkIdAndName(TbGrainDepot depot);

    /**
     * 根据id查询组织类型
     *
     * @param organizeId 组织id
     * @return 组织类型
     */
    String findTypeById(Long organizeId);

    /**
     * 根据所在行政区获取所在区区粮管部门组织id
     *
     * @param region 行政区数字字典
     * @return 区粮管部门组织id
     */
    Long getIdByRegion(String region);

    /**
     * 根据父节点集合获取该区粮管中心组织id
     *
     * @param ids
     * @return
     */
    Long getRegionIdById(String[] ids);

    /**
     * 根据组织id获取所在行政区
     *
     * @param organizeId 组织id
     * @return 行政区
     */
    String getRegionById(Long organizeId);

    /**
     * 获取所有的企业的下拉框
     *
     * @return 下拉框企业信息集合
     */
    List<Map<String, Object>> getSelect();

    /**
     * 获取区粮管中心组织的下拉框
     *
     * @return 所有的企业的下拉框
     */
    List<Map<String, Object>> getCenter();

    /**
     * 根据组织id和组织类型来查询该组织是否存在或者停用
     *
     * @param organizeId 组织id
     * @param type 组织类型
     * @return 结果
     */
    TbOrganize select(@Param("organizeId") Long organizeId, @Param("type") String type);

    @Select("select * from tb_organize where organize_type = #{organizeType}")
    List<TbOrganize> getOrganizeByType(String organizeType);

    /**
     * 根据id集合查询名称集合
     *
     * @param list
     * @return
     */
    List<String> getNamebyIds(List<Long> list);

    /**
     * 根据粮权获取市区组织的组织注释
     *
     * @param organizeId
     * @return
     */
    String getNote(Long organizeId);
}