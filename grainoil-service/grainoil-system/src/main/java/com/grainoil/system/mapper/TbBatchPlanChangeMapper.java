package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbBatchPlanChange;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbBatchPlanChangeMapper {
    /**
     * 查询日常轮换变更记录
     *
     * @param id 日常轮换变更记录ID
     * @return 日常轮换变更记录
     */
    public TbBatchPlanChange selectTbBatchPlanChangeById(Long id);

    /**
     * 查询日常轮换变更记录列表
     *
     * @param tbBatchPlanChange 日常轮换变更记录
     * @return 日常轮换变更记录集合
     */
    public List<TbBatchPlanChange> selectTbBatchPlanChangeList(TbBatchPlanChange tbBatchPlanChange);

    /**
     * 新增日常轮换变更记录
     *
     * @param tbBatchPlanChange 日常轮换变更记录
     * @return 结果
     */
    public int insertTbBatchPlanChange(TbBatchPlanChange tbBatchPlanChange);

    /**
     * 修改日常轮换变更记录
     *
     * @param tbBatchPlanChange 日常轮换变更记录
     * @return 结果
     */
    public int updateTbBatchPlanChange(TbBatchPlanChange tbBatchPlanChange);

    /**
     * 删除日常轮换变更记录
     *
     * @param id 日常轮换变更记录ID
     * @return 结果
     */
    public int deleteTbBatchPlanChangeById(Long id);

    /**
     * 批量删除日常轮换变更记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbBatchPlanChangeByIds(Long[] ids);
}
