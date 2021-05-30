package com.grainoil.system.service;

import com.grainoil.system.domain.TbBatchPlanDepotInfo;

import java.util.List;

public interface ITbBatchPlanDepotInfoService {
    /**
     * 查询日常轮换库存清单
     *
     * @param id 日常轮换库存清单ID
     * @return 日常轮换库存清单
     */
    public TbBatchPlanDepotInfo selectTbBatchPlanDepotInfoById(Long id);

    /**
     * 查询日常轮换库存清单列表
     *
     * @param tbBatchPlanDepotInfo 日常轮换库存清单
     * @return 日常轮换库存清单集合
     */
    public List<TbBatchPlanDepotInfo> selectTbBatchPlanDepotInfoList(TbBatchPlanDepotInfo tbBatchPlanDepotInfo);

    /**
     * 新增日常轮换库存清单
     *
     * @param tbBatchPlanDepotInfo 日常轮换库存清单
     * @return 结果
     */
    public int insertTbBatchPlanDepotInfo(TbBatchPlanDepotInfo tbBatchPlanDepotInfo);

    /**
     * 修改日常轮换库存清单
     *
     * @param tbBatchPlanDepotInfo 日常轮换库存清单
     * @return 结果
     */
    public int updateTbBatchPlanDepotInfo(TbBatchPlanDepotInfo tbBatchPlanDepotInfo);

    /**
     * 批量删除日常轮换库存清单
     *
     * @param ids 需要删除的日常轮换库存清单ID
     * @return 结果
     */
    public int deleteTbBatchPlanDepotInfoByIds(Long[] ids);

    /**
     * 删除日常轮换库存清单信息
     *
     * @param id 日常轮换库存清单ID
     * @return 结果
     */
    public int deleteTbBatchPlanDepotInfoById(Long id);
}
