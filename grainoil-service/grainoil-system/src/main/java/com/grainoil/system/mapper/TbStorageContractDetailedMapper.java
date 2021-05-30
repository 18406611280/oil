package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbStorageContractDetailed;
import com.grainoil.system.domain.vo.storage_contract.StorageContractDetailedVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbStorageContractDetailedMapper {

    /**
     * 批量插入存储合同明细
     *
     * @param list 存储合同明细集合
     */
    void batchInsert(List<StorageContractDetailedVo> list);

    /**
     * 根据id查询合同明细信息
     *
     * @param id 明细信息id
     * @return 结果
     */
    TbStorageContractDetailed selectByPrimaryKey(Long id);

    @Select("select *from tb_storage_contract_detailed where stroage_contract_id = #{id}")
    List<TbStorageContractDetailed> selectByContractId(@Param("id") Long id);
}