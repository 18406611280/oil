package com.grainoil.system.service.impl;

import com.grainoil.system.domain.TbBatchPlanChange;
import com.grainoil.system.mapper.TbBatchPlanChangeMapper;
import com.grainoil.system.service.ITbBatchPlanChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbBatchPlanChangeServiceImpl implements ITbBatchPlanChangeService {
    @Autowired
    private TbBatchPlanChangeMapper tbBatchPlanChangeMapper;

    /**
     * 查询日常轮换变更记录
     *
     * @param id 日常轮换变更记录ID
     * @return 日常轮换变更记录
     */
    @Override
    public TbBatchPlanChange selectTbBatchPlanChangeById(Long id)
    {
        return tbBatchPlanChangeMapper.selectTbBatchPlanChangeById(id);
    }

    /**
     * 查询日常轮换变更记录列表
     *
     * @param tbBatchPlanChange 日常轮换变更记录
     * @return 日常轮换变更记录
     */
    @Override
    public List<TbBatchPlanChange> selectTbBatchPlanChangeList(TbBatchPlanChange tbBatchPlanChange)
    {
        return tbBatchPlanChangeMapper.selectTbBatchPlanChangeList(tbBatchPlanChange);
    }

    /**
     * 新增日常轮换变更记录
     *
     * @param tbBatchPlanChange 日常轮换变更记录
     * @return 结果
     */
    @Override
    public int insertTbBatchPlanChange(TbBatchPlanChange tbBatchPlanChange)
    {
        return tbBatchPlanChangeMapper.insertTbBatchPlanChange(tbBatchPlanChange);
    }

    /**
     * 修改日常轮换变更记录
     *
     * @param tbBatchPlanChange 日常轮换变更记录
     * @return 结果
     */
    @Override
    public int updateTbBatchPlanChange(TbBatchPlanChange tbBatchPlanChange)
    {
        return tbBatchPlanChangeMapper.updateTbBatchPlanChange(tbBatchPlanChange);
    }

    /**
     * 批量删除日常轮换变更记录
     *
     * @param ids 需要删除的日常轮换变更记录ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanChangeByIds(Long[] ids)
    {
        return tbBatchPlanChangeMapper.deleteTbBatchPlanChangeByIds(ids);
    }

    /**
     * 删除日常轮换变更记录信息
     *
     * @param id 日常轮换变更记录ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanChangeById(Long id)
    {
        return tbBatchPlanChangeMapper.deleteTbBatchPlanChangeById(id);
    }
}
