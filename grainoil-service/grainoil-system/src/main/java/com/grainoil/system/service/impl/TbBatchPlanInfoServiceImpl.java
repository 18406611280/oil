package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.utils.DateUtils;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbBatchPlanInfo;
import com.grainoil.system.domain.vo.rotate.BatchPlanDepotInfo;
import com.grainoil.system.domain.vo.rotate.BatchPlanInfo;
import com.grainoil.system.mapper.TbBatchPlanInfoMapper;
import com.grainoil.system.service.ITbBatchPlanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbBatchPlanInfoServiceImpl implements ITbBatchPlanInfoService {
    @Autowired
    private TbBatchPlanInfoMapper tbBatchPlanInfoMapper;

    /**
     * 查询日常轮换申请单
     *
     * @param id 日常轮换申请单ID
     * @return 日常轮换申请单
     */
    @Override
    public TbBatchPlanInfo selectTbBatchPlanInfoById(Long id)
    {
        return tbBatchPlanInfoMapper.selectTbBatchPlanInfoById(id);
    }

    /**
     * 查询日常轮换申请单列表
     *
     * @param tbBatchPlanInfo 日常轮换申请单
     * @return 日常轮换申请单
     */
    @Override
    public List<TbBatchPlanInfo> selectTbBatchPlanInfoList(TbBatchPlanInfo tbBatchPlanInfo)
    {
        return tbBatchPlanInfoMapper.selectTbBatchPlanInfoList(tbBatchPlanInfo);
    }

    /**
     * 新增日常轮换申请单
     *
     * @param tbBatchPlanInfo 日常轮换申请单
     * @return 结果
     */
    @Override
    public int insertTbBatchPlanInfo(TbBatchPlanInfo tbBatchPlanInfo)
    {
        return tbBatchPlanInfoMapper.insertTbBatchPlanInfo(tbBatchPlanInfo);
    }

    /**
     * 修改日常轮换申请单
     *
     * @param tbBatchPlanInfo 日常轮换申请单
     * @return 结果
     */
    @Override
    public int updateTbBatchPlanInfo(TbBatchPlanInfo tbBatchPlanInfo)
    {
        return tbBatchPlanInfoMapper.updateTbBatchPlanInfo(tbBatchPlanInfo);
    }

    /**
     * 批量删除日常轮换申请单
     *
     * @param ids 需要删除的日常轮换申请单ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanInfoByIds(Long[] ids)
    {
        return tbBatchPlanInfoMapper.deleteTbBatchPlanInfoByIds(ids);
    }

    /**
     * 删除日常轮换申请单信息
     *
     * @param id 日常轮换申请单ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanInfoById(Long id)
    {
        return tbBatchPlanInfoMapper.deleteTbBatchPlanInfoById(id);
    }

    /**
     * 编辑日常轮换计划
     *
     * @param batchPlanInfo
     * @return
     */
    @Override
    //@Transactional
    public ResponseResult editBatchPlanInfo(BatchPlanInfo batchPlanInfo) {

        // 1.前端时间范围格式转换
        BatchPlanInfo batchPlanInfo1 = transferBatchPlanInfo(batchPlanInfo);
        // 2.修改日常轮换清单
        tbBatchPlanInfoMapper.editBatchPlanInfo(batchPlanInfo1);
        // 3.新增日常轮换库存清单
        insertTbBatchPlanDepotInfo(batchPlanInfo);

        return ResponseResult.success();
    }

    /**
     *  新增日常轮换计划
     *
     * @param batchPlanInfo
     * @return
     */
    @Override
    //@Transactional
    public ResponseResult addBatchPlanInfo(BatchPlanInfo batchPlanInfo) {

        // 1.前端时间范围格式转换
        BatchPlanInfo batchPlanInfo1 = transferBatchPlanInfo(batchPlanInfo);
        // 2.新增日常轮换清单
        tbBatchPlanInfoMapper.insertBatchPlanInfo(batchPlanInfo1);
        // 3.新增日常轮换库存清单
        insertTbBatchPlanDepotInfo(batchPlanInfo);

        return ResponseResult.success();
    }

    /**
     * 日常轮换申请单 时间格式转换
     *
     * @param batchPlanInfo
     * @return
     */
    private BatchPlanInfo transferBatchPlanInfo(BatchPlanInfo batchPlanInfo){

        batchPlanInfo.setRemoveBeginDate(DateUtils.strToDate(batchPlanInfo.getRemoveDateList().get(0)));
        batchPlanInfo.setRemoveEndDate(DateUtils.strToDate(batchPlanInfo.getRemoveDateList().get(1)));
        batchPlanInfo.setMoveInBeginDate(DateUtils.strToDate(batchPlanInfo.getMoveInDateList().get(0)));
        batchPlanInfo.setMoveInEndDate(DateUtils.strToDate(batchPlanInfo.getMoveInDateList().get(1)));

        return batchPlanInfo;
    }

    /**
     * 新增日常轮换库存清单信息
     *
     * @param batchPlanInfo 日常轮换申请单对象
     */
    public void insertTbBatchPlanDepotInfo(BatchPlanInfo batchPlanInfo)
    {
        List<BatchPlanDepotInfo> tbBatchPlanDepotInfoList = batchPlanInfo.getBatchPlanDepotInfoList();
        Long id = batchPlanInfo.getId();
        if (StringUtils.isNotNull(tbBatchPlanDepotInfoList))
        {
            List<BatchPlanDepotInfo> list = new ArrayList<BatchPlanDepotInfo>();
            for (BatchPlanDepotInfo tbBatchPlanDepotInfo : tbBatchPlanDepotInfoList)
            {
                tbBatchPlanDepotInfo.setBatchPlanInfoId(id);
                list.add(tbBatchPlanDepotInfo);
            }
            if (list.size() > 0)
            {
                tbBatchPlanInfoMapper.batchBatchPlanDepotInfo(list);
            }
        }
    }
}
