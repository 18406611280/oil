package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbBatchPlanDepotInfo;
import com.grainoil.system.domain.vo.rotate.BatchPlanDepotInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbBatchPlanDepotInfoMapper {
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
     * 删除日常轮换库存清单
     *
     * @param id 日常轮换库存清单ID
     * @return 结果
     */
    public int deleteTbBatchPlanDepotInfoById(Long id);

    /**
     * 批量删除日常轮换库存清单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbBatchPlanDepotInfoByIds(Long[] ids);

    /**
     * 通过申请单id获取库存清单列表
     *
     * @param batchPlanInfoId
     * @return
     */
    public List<BatchPlanDepotInfo> getBatchPlanDepotInfoListByBatchPlanInfoId(Long batchPlanInfoId);
}
