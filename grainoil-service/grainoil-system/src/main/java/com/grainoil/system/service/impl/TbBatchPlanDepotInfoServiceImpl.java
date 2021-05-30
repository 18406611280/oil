package com.grainoil.system.service.impl;

import com.grainoil.system.domain.TbBatchPlanDepotInfo;
import com.grainoil.system.mapper.TbBatchPlanDepotInfoMapper;
import com.grainoil.system.service.ITbBatchPlanDepotInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbBatchPlanDepotInfoServiceImpl implements ITbBatchPlanDepotInfoService {
    @Autowired
    private TbBatchPlanDepotInfoMapper tbBatchPlanDepotInfoMapper;

    /**
     * 查询日常轮换库存清单
     *
     * @param id 日常轮换库存清单ID
     * @return 日常轮换库存清单
     */
    @Override
    public TbBatchPlanDepotInfo selectTbBatchPlanDepotInfoById(Long id)
    {
        return tbBatchPlanDepotInfoMapper.selectTbBatchPlanDepotInfoById(id);
    }

    /**
     * 查询日常轮换库存清单列表
     *
     * @param tbBatchPlanDepotInfo 日常轮换库存清单
     * @return 日常轮换库存清单
     */
    @Override
    public List<TbBatchPlanDepotInfo> selectTbBatchPlanDepotInfoList(TbBatchPlanDepotInfo tbBatchPlanDepotInfo)
    {
        return tbBatchPlanDepotInfoMapper.selectTbBatchPlanDepotInfoList(tbBatchPlanDepotInfo);
    }

    /**
     * 新增日常轮换库存清单
     *
     * @param tbBatchPlanDepotInfo 日常轮换库存清单
     * @return 结果
     */
    @Override
    public int insertTbBatchPlanDepotInfo(TbBatchPlanDepotInfo tbBatchPlanDepotInfo)
    {
        return tbBatchPlanDepotInfoMapper.insertTbBatchPlanDepotInfo(tbBatchPlanDepotInfo);
    }

    /**
     * 修改日常轮换库存清单
     *
     * @param tbBatchPlanDepotInfo 日常轮换库存清单
     * @return 结果
     */
    @Override
    public int updateTbBatchPlanDepotInfo(TbBatchPlanDepotInfo tbBatchPlanDepotInfo)
    {
        return tbBatchPlanDepotInfoMapper.updateTbBatchPlanDepotInfo(tbBatchPlanDepotInfo);
    }

    /**
     * 批量删除日常轮换库存清单
     *
     * @param ids 需要删除的日常轮换库存清单ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanDepotInfoByIds(Long[] ids)
    {
        return tbBatchPlanDepotInfoMapper.deleteTbBatchPlanDepotInfoByIds(ids);
    }

    /**
     * 删除日常轮换库存清单信息
     *
     * @param id 日常轮换库存清单ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanDepotInfoById(Long id)
    {
        return tbBatchPlanDepotInfoMapper.deleteTbBatchPlanDepotInfoById(id);
    }
}
