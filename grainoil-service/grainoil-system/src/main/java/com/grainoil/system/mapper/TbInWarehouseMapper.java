package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.vo.in_warehouse.InWarehouseListVo;
import com.grainoil.system.domain.vo.in_warehouse.InWarehouseQuery;
import com.grainoil.system.domain.vo.in_warehouse.ListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbInWarehouseMapper {

    /**
     * 添加入仓单
     *
     * @param record 入仓单信息
     * @return 结果
     */
    int insert(TbInWarehouse record);

    /**
     * 根据入仓单id获取入仓单信息
     *
     * @param id 入仓单id
     * @return 结果
     */
    TbInWarehouse selectByPrimaryKey(Long id);

    /**
     * 修改入仓单信息
     *
     * @param record 入仓单信息
     * @return 结果
     */
    int updateByPrimaryKey(TbInWarehouse record);

    /**
     * 根据条件查询入仓单列表
     *
     * @param inWarehouse 入仓单条件
     * @return 入仓单列表
     */
    List<InWarehouseListVo> list(@Param("inWarehouse") InWarehouseQuery inWarehouse, @Param("organizeType") String organizeType, @Param("organizeId") Long organizeId, @Param("lq") Long lq);

    /**
     * 验证批文编号,粮库id,仓房id,粮油品种id是否正确
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    Integer check(TbInWarehouse inWarehouse);

    /**
     * 修改入仓单状态
     *
     * @param id
     * @param state
     * @param currentUser
     */
    void changState(@Param("id") Long id, @Param("state") String state, @Param("currentUser") CurrentUser currentUser);

    /**
     * 入仓单录入明细的添加按钮
     *
     * @param id 入仓通知单id
     * @return
     */
    List<ListVo> getInsertButton(Long id);

    /**
     * 查询审批下一条同状态的id
     *
     * @param organizeId 组织id
     * @param code       入库状态
     * @return
     */
    List<Long> getNextId(@Param("organizeId") Long organizeId, @Param("lq") Long lq, @Param("code") String code);

    /**
     * 查询入仓通知单有待审核的入仓单的下一个id
     *
     * @param organizeId
     * @param code
     * @return
     */
    List<Long> getNextId2(@Param("organizeId") Long organizeId, @Param("lq") Long lq, @Param("code") String code);
}