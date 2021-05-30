package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbStorageContract;
import com.grainoil.system.domain.vo.in_warehouse.DropDownVo;
import com.grainoil.system.domain.vo.storage_contract.StorageContractVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbStorageContractMapper {

    /**
     * 添加存储合同
     *
     * @param record 存储合同信息
     * @return 结果
     */
    void insert(@Param("record") StorageContractVo record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据id查询存储合同信息
     *
     * @param id 存储合同id
     * @return 合同信息
     */
    TbStorageContract selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TbStorageContract record);

    /**
     * 根据条件查询承储企业存储合同列表信息
     *
     * @param map        查询条件
     * @param organizeId 组织部门id
     * @return 存储合同列表
     */
    List<Map<String, Object>> list2(@Param("map") Map<String, Object> map, @Param("organizeId") Long organizeId);

    /**
     * 根据入库类型获取批文编号
     *
     * @param organizeId 企业id
     * @return 批文编号列表
     */
    List<Map<String, Object>> getBatchCode(Long organizeId);

    /**
     * 根据批文编号id查询粮库,粮油品种的数据
     *
     * @param id 批文编号id
     * @return 结果
     */
    List<DropDownVo> getData(Long id);

    /**
     * 根据批文编号id查询粮库,仓房的数据
     *
     * @param id 批文编号id
     * @return 结果
     */
    List<DropDownVo> getData2(Long id);

    /**
     * 根据条件查询市(区)存储合同列表信息
     *
     * @param map        查询条件
     * @param organizeId 组织部门id
     * @return 存储合同列表
     */
    List<Map<String, Object>> list(@Param("map") Map<String, Object> map, @Param("organizeId") Long organizeId);
}