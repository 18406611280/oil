package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbVariety;
import com.grainoil.system.domain.vo.variety.VarietyChildren;
import com.grainoil.system.domain.vo.variety.VarietyVo;
import com.grainoil.system.domain.vo.variety.VarietyListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TbVarietyMapper {

    /**
     * 添加粮油品种信息
     *
     * @param record 粮油品种信息
     * @return 结果
     */
    int insert(@Param("record") VarietyVo record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据id 查询粮油品种信息
     *
     * @param varietyId 粮油品种id
     * @return 粮油品种信息
     */
    TbVariety selectByPrimaryKey(Long varietyId);

    /**
     * 修改粮油品种信息
     *
     * @param record 粮油品种信息
     * @return 结果
     */
    int updateByPrimaryKey(@Param("record") VarietyVo record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 验证粮油品种名称和拼音简称是否存在
     *
     * @param names      名称集合
     * @param shortnames 简称集合
     * @param b          修改/添加
     * @param varietyVo  粮油信息
     * @return 结果
     */
    Integer checkName(@Param("names") Set<String> names, @Param("shortnames") Set<String> shortnames, @Param("b") boolean b, @Param("varietyVo") VarietyVo varietyVo);

    /**
     * 查询粮油品种列表
     *
     * @return 结果
     */
    List<VarietyListVo> list();

    /**
     * 批量添加二级粮油品种
     *
     * @param varietyList 二级粮油品种集合
     * @return 结果
     */
    int batchInsert(@Param("varietyList") List<VarietyChildren> varietyList, @Param("id") Long id, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据id查询父节点id
     *
     * @param id 主键id
     * @return 父节点id
     */
    Long getParentId(Long id);

    /**
     * 根据父节点id查询二级粮油品种信息集合
     *
     * @param id 父节点id
     * @return 粮油品种信息集合
     */
    List<VarietyChildren> selectByParentId(Long id);

    /**
     * 根据id删除粮油品种信息
     *
     * @param tbVariety 粮油品种信息
     * @return 结果
     */
    Integer delete(TbVariety tbVariety);

    /**
     * 根据父节点id批量删除二级粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return 结果
     */
    Integer batchDelete(@Param("varietyVo") VarietyVo varietyVo, @Param("currentUser") CurrentUser currentUser);

    /**
     * 统计节点之下的二级粮油品种数量
     *
     * @param varietyId id
     * @return 数量
     */
    Integer count(Long varietyId);

    /**
     * 根据id集合验证粮油品种数量是否正确
     *
     * @param vSet 粮油品种id集合
     * @return 粮油品种列表
     */
    List<TbVariety> checkContract(Set<Long> vSet);

    /**
     * 获取粮油品种下拉框列表
     *
     * @return 粮油品种下拉框
     */
    List<Map<String, Object>> getSelect();

}