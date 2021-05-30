package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.storage_contract.StorageContractVo;

import java.util.List;
import java.util.Map;

public interface ITbStorageContractService {

    /**
     * 插入存储合同以及明细
     *
     * @param storageContract 存储合同信息
     * @return 结果
     */
    ResponseResult insert(StorageContractVo storageContract, CurrentUser currentUser);

    /**
     * 根据条件查询存储合同列表数据
     *
     * @param map 查询列表条件
     * @return 列表数据
     */
    List<Map<String, Object>> list(Map<String, Object> map, String organizeType, Long organizeId);

    /**
     * 根据id查询合同信息
     *
     * @param id id
     * @return 结果
     */
    R get(Long id);
}
