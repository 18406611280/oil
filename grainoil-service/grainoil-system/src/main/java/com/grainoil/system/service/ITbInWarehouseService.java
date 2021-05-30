package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.vo.in_warehouse.*;

import java.util.List;

public interface ITbInWarehouseService {

    /**
     * 添加入仓单
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    R insert(TbInWarehouse inWarehouse);

    /**
     * 根据id获取查看时入仓单信息
     *
     * @param id 入仓单id
     * @return 入仓单信息
     */
    ResponseResult<InWarehouseVo> get(Long id);

    /**
     * 根据条件查询入仓单信息
     *
     * @param inWarehouse 入仓单条件
     * @return 入仓单列表
     */
    ResponseResult<PageView<InWarehouseListVo>> list(InWarehouseQuery inWarehouse, String organizeType, Long organizeId, Long lq);

    /**
     * 根据入库类型获取批文编号
     *
     * @param type 入库类型(数字字典)
     * @param organizeId 企业id
     * @return 批文编号列表
     */
    R getBatchCode(String type, Long organizeId);

    /**
     * 根据批文编号id查询粮库,粮油品种,仓房的数据
     *
     * @param id 批文编号id
     * @param type 入库类型
     * @return 结果
     */
    ResponseResult<List<DropDownVo>> getData(String type, Long id);

    /**
     * 更新入仓单信息(保存)
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    R updateSave(TbInWarehouse inWarehouse);

    /**
     * 更新入仓单信息(提交)
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    R updateSubmit(TbInWarehouse inWarehouse);

    /**
     * 录入明细提交或者数据错误提交
     *
     * @param inWarehouse 入仓单明细信息
     * @return 结果
     */
    ResponseResult inputDetail(InWarehouseDetailDto inWarehouse, CurrentUser currentUser);

    /**
     * 审批
     *
     * @param approveDto 审批入参
     * @return
     */
    ResponseResult approve(ApproveDto approveDto, CurrentUser currentUser, List<String> roleIds);

    /**
     * 审核
     *
     * @param auditDto 审核入参
     * @return
     */
    ResponseResult audit(AuditDto auditDto, CurrentUser currentUser, List<String> roleIds);

    /**
     * 入仓单录入明细的添加按钮
     *
     * @param id 入仓通知单id
     * @return
     */
    List<ListVo> getInsertButton(Long id);
}
