package com.grainoil.system.service;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.TbBatchPlan;
import com.grainoil.system.domain.vo.rotate.BatchPlan;
import com.grainoil.system.domain.vo.rotate.BatchPlanEntity;
import com.grainoil.system.domain.vo.rotate.BatchPlanVo;
import com.grainoil.system.domain.vo.rotate.dto.BatchPlanPageDto;

import java.util.List;

public interface ITbBatchPlanService {
    /**
     * 查询日常轮换计划
     *
     * @param id 日常轮换计划ID
     * @return 日常轮换计划
     */
    public TbBatchPlan selectTbBatchPlanById(Long id);

    /**
     * 查询日常轮换计划列表
     *
     * @param tbBatchPlan 日常轮换计划
     * @return 日常轮换计划集合
     */
    public List<BatchPlanEntity> selectTbBatchPlanList(TbBatchPlan tbBatchPlan , Long organizeId, String organizeType );

    /**
     * 申请日常计划时 显示企业用户所选的列表
     *
     * @param
     * @return 日常轮换计划集合
     */
    public List<BatchPlanVo> selectBatchPlanVoList();

    /**
     * 新增日常轮换计划
     *
     * @param tbBatchPlan 日常轮换计划
     * @return 结果
     */
    public int insertTbBatchPlan(TbBatchPlan tbBatchPlan);

    /**
     * 修改日常轮换计划
     *
     * @param tbBatchPlan 日常轮换计划
     * @return 结果
     */
    public int updateTbBatchPlan(TbBatchPlan tbBatchPlan);

    /**
     * 批量删除日常轮换计划
     *
     * @param ids 需要删除的日常轮换计划ID
     * @return 结果
     */
    public int deleteTbBatchPlanByIds(Long[] ids);

    /**
     * 删除日常轮换计划信息
     *
     * @param id 日常轮换计划ID
     * @return 结果
     */
    public int deleteTbBatchPlanById(Long id);

    /**
     * 分页列表
     *
     * @param dto
     * @return
     */
    public PageView<BatchPlanEntity> page(BatchPlanPageDto dto,Long organizeId, String organizeType ,Long lq);

    /**
     * 通过id 获取日常轮换计划的状态 有不同按钮的操作
     * @param id
     * @return
     */
    public ResponseResult getBatchPlanById(Long id);

    /**
     * 通过id 终止已审批状态的数据
     * @param id
     * @return
     */
    public ResponseResult terminateState(Long id);

    /**
     * 日常轮换计划变更申请
     *
     * @param batchPlan
     * @return
     */
    public ResponseResult changeRotate(BatchPlan batchPlan);

    /**
     * 申请日常轮换计划 所展示的年度计划详情
     *
     * @return
     */
    public ResponseResult getAnnualDetail(Long organizeId,String organizeType , Long lq);

    /**
     * 审批--日常轮换（当前只修改状态）
     *
     * @param id
     * @return
     */
    public ResponseResult approveBatchPlan(Long id);
}
