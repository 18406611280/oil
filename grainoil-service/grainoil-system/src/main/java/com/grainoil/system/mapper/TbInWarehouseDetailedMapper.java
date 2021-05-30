package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.TbInWarehouseDetailed;
import com.grainoil.system.domain.vo.in_warehouse.InWarehouseDetailDto;
import com.grainoil.system.domain.vo.in_warehouse.InWarehouseDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbInWarehouseDetailedMapper {

    /**
     * 根据入仓单id查询入仓单明细
     *
     * @param id 入仓单id
     * @return 入仓单明细列表
     */
    List<InWarehouseDetailVo> get(Long id);

    /**
     * 批量逻辑删除入仓单明细表中指定入仓单明细信息审核不通过的数据
     *
     * @param inWarehouse 入仓单信息
     */
    void batchDelete(@Param("inWarehouse") InWarehouseDetailDto inWarehouse, @Param("currentUser") CurrentUser currentUser);

    /**
     * 批量添加入仓单明细信息
     *
     * @param inWarehouse 入仓单信息
     * @return 添加的数量
     */
    void batchInsert(@Param("inWarehouse") InWarehouseDetailDto inWarehouse, @Param("currentUser") CurrentUser currentUser);

    /**
     * 检验待审核的入仓单明细信息是否正确
     *
     * @param id  入仓通知单id
     * @param ids 入仓单明细表需要验证的id集合
     * @return
     */
    Integer check(@Param("id") Long id, @Param("ids") List<Long> ids);

    /**
     * 入仓单明细表修改审核状态为'数据有误'
     *
     * @param id          入仓通知单id
     * @param ids         有误的入仓单明细表id集合
     * @param currentUser 用户信息
     */
    void wrong(@Param("id") Long id, @Param("ids") List<Long> ids, @Param("currentUser") CurrentUser currentUser);

    /**
     * 入仓单明细表修改审核状态为'已审核'
     *
     * @param ids         有误的入仓单明细表id集合
     * @param currentUser 用户信息
     */
    void correct(@Param("ids") List<Long> ids, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据入仓单id查询入仓单明细(单指录入明细时)
     *
     * @param id
     * @return
     */
    List<InWarehouseDetailVo> get2(Long id);

    /**
     * 计算审核通过的入仓单明细数量之和
     *
     * @param ids 审核通过的入仓单明细id集合
     * @return
     */
    Double count(List<Long> ids);

    /**
     * 检验数据错误的入仓单明细信息是否正确
     *
     * @param id  入仓通知单id
     * @param ids 入仓单明细表需要验证的id集合
     * @return
     */
    Integer check2(@Param("id") Long id, @Param("ids") List<Long> ids);

    /**
     * 根据入仓明细表id集合查询记录
     *
     * @param ids
     * @return
     */
    List<TbInWarehouseDetailed> getListByIds(List<Long> ids);
}