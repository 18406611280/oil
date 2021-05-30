package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbBatchPlan;
import com.grainoil.system.domain.vo.rotate.AnnualPlanForBatchPlan;
import com.grainoil.system.domain.vo.rotate.BatchPlanEntity;
import com.grainoil.system.domain.vo.rotate.dto.BatchPlanPageDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbBatchPlanMapper {

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
    public List<TbBatchPlan> selectTbBatchPlanList(TbBatchPlan tbBatchPlan);

    /**
     * 角色为市区粮管中心时日常轮换计划列表
     *
     * @param batchPlanPageDto  日常轮换计划
     * @param organizeId 市区组织id
     * @return 粮库列表集合
     */
    List<BatchPlanEntity> select(@Param("batchPlanPageDto") BatchPlanPageDto batchPlanPageDto, @Param("organizeId") Long organizeId);

    /**
     * 角色为时日常轮换计划列表
     *
     * @param batchPlanPageDto  日常轮换计划
     * @param organizeId 市区组织id
     * @return 粮库列表集合
     */
    List<BatchPlanEntity> list(@Param("batchPlanPageDto")BatchPlanPageDto batchPlanPageDto, @Param("organizeType") String organizeType, @Param("organizeId") Long organizeId, @Param("lq") Long lq);


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
     * 删除日常轮换计划
     *
     * @param id 日常轮换计划ID
     * @return 结果
     */
    public int deleteTbBatchPlanById(Long id);

    /**
     * 批量删除日常轮换计划
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbBatchPlanByIds(Long[] ids);


    /**
     * 终止 状态为已审批的数据
     *
     * @param id
     * @param state
     * @return
     */
    public int updateStateByStateAndId(@Param("id") Long id,@Param("state") String state);

    /**
     * 获取本年度详细信息
     *
     * @param organizeId
     * @param organizeType
     * @param lq
     * @param year
     * @return
     */
    public List<AnnualPlanForBatchPlan> getAnnualPlanDetail(@Param("organizeId") Long organizeId, @Param("organizeType") String organizeType,
                                                                    @Param("lq") Long lq, @Param("year") String year);

    /**
     *  审批修改状态
     *
     * @param id
     * @param state
     * @return
     */
    public int approveBatchPlan(@Param("id") Long id, @Param("state") String state);
}
