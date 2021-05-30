package com.grainoil.system.service;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.TbBatchPlanInfo;
import com.grainoil.system.domain.vo.rotate.BatchPlanInfo;

import java.util.List;

public interface ITbBatchPlanInfoService {
    /**
     * 查询日常轮换申请单
     *
     * @param id 日常轮换申请单ID
     * @return 日常轮换申请单
     */
    public TbBatchPlanInfo selectTbBatchPlanInfoById(Long id);

    /**
     * 查询日常轮换申请单列表
     *
     * @param tbBatchPlanInfo 日常轮换申请单
     * @return 日常轮换申请单集合
     */
    public List<TbBatchPlanInfo> selectTbBatchPlanInfoList(TbBatchPlanInfo tbBatchPlanInfo);

    /**
     * 新增日常轮换申请单
     *
     * @param tbBatchPlanInfo 日常轮换申请单
     * @return 结果
     */
    public int insertTbBatchPlanInfo(TbBatchPlanInfo tbBatchPlanInfo);

    /**
     * 修改日常轮换申请单
     *
     * @param tbBatchPlanInfo 日常轮换申请单
     * @return 结果
     */
    public int updateTbBatchPlanInfo(TbBatchPlanInfo tbBatchPlanInfo);

    /**
     * 批量删除日常轮换申请单
     *
     * @param ids 需要删除的日常轮换申请单ID
     * @return 结果
     */
    public int deleteTbBatchPlanInfoByIds(Long[] ids);

    /**
     * 删除日常轮换申请单信息
     *
     * @param id 日常轮换申请单ID
     * @return 结果
     */
    public int deleteTbBatchPlanInfoById(Long id);

    /**
     * 编辑日常轮换信息
     *
     * @param batchPlanInfo
     * @return
     */
    public ResponseResult editBatchPlanInfo(BatchPlanInfo batchPlanInfo);

    /**
     * 申请日常轮换信息
     *
     * @param batchPlanInfo
     * @return
     */
    public ResponseResult addBatchPlanInfo(BatchPlanInfo batchPlanInfo);
}
