package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.TbInWarehouseDetailedCheck;
import com.grainoil.system.domain.vo.in_warehouse.ApproveDto;
import com.grainoil.system.domain.vo.in_warehouse.AuditDto;
import com.grainoil.system.domain.vo.in_warehouse.InWarehouseDetailDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbInWarehouseDetailedCheckMapper {

    int deleteByPrimaryKey(Long id);

    /**
     * 添加审批记录
     *
     * @param inWarehouse
     * @param approveDto
     * @param currentUser
     */
    void insert(@Param("inWarehouse") TbInWarehouse inWarehouse, @Param("approveDto") ApproveDto approveDto, @Param("currentUser") CurrentUser currentUser);

    TbInWarehouseDetailedCheck selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TbInWarehouseDetailedCheck record);

    /**
     * 添加审核通过记录
     *
     * @param type
     * @param auditDto
     * @param currentUser
     */
    void insertTrue(@Param("type") String type, @Param("auditDto") AuditDto auditDto, @Param("currentUser") CurrentUser currentUser);

    /**
     * 添加审核通过记录
     *
     * @param type
     * @param auditDto
     * @param currentUser
     */
    void insertFalse(String type, AuditDto auditDto, List<Long> ids, CurrentUser currentUser);

    /**
     * 添加审核通过记录
     *
     * @param type
     * @param currentUser
     */
    void insertTrue2(String type, List<Long> ids, CurrentUser currentUser);

    /**
     * 批量删除入仓单的审核记录
     *
     * @param inWarehouse
     */
    void batchDelete(InWarehouseDetailDto inWarehouse);
}