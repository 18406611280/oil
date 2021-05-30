package com.grainoil.system.service;

import com.grainoil.common.core.domain.R;
import com.grainoil.system.domain.TbOrganize;
import com.grainoil.system.domain.vo.OrganizeTreeVo;

import java.util.List;

/**
 * 组织信息管理 业务层
 */
public interface ITbOrganizeService {

    /**
     * 根据条件分页查询组织信息列表
     *
     * @param organizeName 组织名称
     * @param organizeType 组织类型
     * @param organizeId 组织id
     * @return 组织信息集合
     */
    List<TbOrganize> list(String organizeName, String  organizeType, Long organizeId);

    /**
     * 添加组织信息
     *
     * @param organize 组织信息
     * @return number
     */
    R insert(TbOrganize organize, Long organizeId);

    /**
     * 获取组织管理树
     *
     * @param id 树的根节点id
     * @return 组织管理树结构
     */
    List<OrganizeTreeVo> getTree(Long id);

    /**
     * 根据id获取组织信息
     *
     * @param organizeId 组织id
     * @return 组织信息
     */
    R get(Long organizeId);

    /**
     * 修改组织信息
     *
     * @param organize 组织信息
     * @return number
     */
    R update(TbOrganize organize);

    /**
     * 获取所有的企业的下拉框
     *
     * @return 结果
     */
    R getSelect();

    /**
     * 获取区粮管中心组织的下拉框
     *
     * @return 所有的企业的下拉框
     */
    R getCenter();
}
