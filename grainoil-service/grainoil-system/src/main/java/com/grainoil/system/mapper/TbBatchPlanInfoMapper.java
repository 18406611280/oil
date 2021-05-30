package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbBatchPlan;
import com.grainoil.system.domain.TbBatchPlanDepotInfo;
import com.grainoil.system.domain.TbBatchPlanInfo;
import com.grainoil.system.domain.vo.rotate.BatchPlan;
import com.grainoil.system.domain.vo.rotate.BatchPlanDepotInfo;
import com.grainoil.system.domain.vo.rotate.BatchPlanInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbBatchPlanInfoMapper {
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
     * 编辑日常轮换申请单
     *
     * @param batchPlanInfo 日常轮换申请单
     * @return 结果
     */
    public int editBatchPlanInfo(BatchPlanInfo batchPlanInfo);

    /**
     * 删除日常轮换申请单
     *
     * @param id 日常轮换申请单ID
     * @return 结果
     */
    public int deleteTbBatchPlanInfoById(Long id);

    /**
     * 批量删除日常轮换申请单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbBatchPlanInfoByIds(Long[] ids);

    /**
     * 通过轮换计划id获取轮换申请单
     *
     * @param batchPlanId
     * @return
     */
    public BatchPlanInfo getBatchPlanInfoByBatchPlanId(Long batchPlanId);

    /**
     * 通过id查询状态为已审批和终止待审批的具体数据
     *
     * @param id
     * @return
     */
    public BatchPlan getBatchPlanById(Long id);

    /**
     * 批量新增日常轮换库存清单
     *
     * @param tbBatchPlanDepotInfoList 日常轮换库存清单列表
     * @return 结果
     */
    public int batchBatchPlanDepotInfo(List<BatchPlanDepotInfo> tbBatchPlanDepotInfoList);


    /**
     * 通过日常轮换申请单ID删除日常轮换库存清单信息
     *
     * @param batchPlanInfoId 日常轮换申请单id
     * @return 结果
     */
    public int deleteBatchPlanDepotInfoByBatchPlanInfoId(Long batchPlanInfoId);

    /**
     * 新增日常轮换申请单
     *
     * @param batchPlanInfo 日常轮换申请单
     * @return 结果
     */
    public int insertBatchPlanInfo(BatchPlanInfo batchPlanInfo);
}
