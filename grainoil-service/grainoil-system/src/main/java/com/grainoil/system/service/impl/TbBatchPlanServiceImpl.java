package com.grainoil.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.BatchPlanStateEnum;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.common.utils.DateUtils;
import com.grainoil.system.domain.TbBatchPlan;
import com.grainoil.system.domain.TbBatchPlanChange;
import com.grainoil.system.domain.vo.rotate.*;
import com.grainoil.system.domain.vo.rotate.dto.BatchPlanPageDto;
import com.grainoil.system.exception.CustomException;
import com.grainoil.system.mapper.TbBatchPlanChangeMapper;
import com.grainoil.system.mapper.TbBatchPlanDepotInfoMapper;
import com.grainoil.system.mapper.TbBatchPlanInfoMapper;
import com.grainoil.system.mapper.TbBatchPlanMapper;
import com.grainoil.system.service.ITbBatchPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TbBatchPlanServiceImpl implements ITbBatchPlanService {
    @Autowired
    private TbBatchPlanMapper tbBatchPlanMapper;
    @Autowired
    private TbBatchPlanInfoMapper tbBatchPlanInfoMapper;
    @Autowired
    private TbBatchPlanDepotInfoMapper tbBatchPlanDepotInfoMapper;
    @Autowired
    private TbBatchPlanChangeMapper tbBatchPlanChangeMapper;


    /**
     * 查询日常轮换计划
     *
     * @param id 日常轮换计划ID
     * @return 日常轮换计划
     */
    @Override
    public TbBatchPlan selectTbBatchPlanById(Long id)
    {
        return tbBatchPlanMapper.selectTbBatchPlanById(id);
    }

    /**
     * 查询日常轮换计划列表
     *
     * @param tbBatchPlan 日常轮换计划
     * @return 日常轮换计划
     */
    @Override
    public List<BatchPlanEntity> selectTbBatchPlanList(TbBatchPlan tbBatchPlan, Long organizeId, String organizeType)
    {
        return null;
    }

    @Override
    public List<BatchPlanVo> selectBatchPlanVoList() {
        // 查询本年度的计划

        return null;
    }

    /**
     * 新增日常轮换计划
     *
     * @param tbBatchPlan 日常轮换计划
     * @return 结果
     */
    @Override
    public int insertTbBatchPlan(TbBatchPlan tbBatchPlan)
    {

        tbBatchPlan.setCreateTime(DateUtils.getNowDate());
        return tbBatchPlanMapper.insertTbBatchPlan(tbBatchPlan);
    }

    /**
     * 修改日常轮换计划
     *
     * @param tbBatchPlan 日常轮换计划
     * @return 结果
     */
    @Override
    public int updateTbBatchPlan(TbBatchPlan tbBatchPlan)
    {
        tbBatchPlan.setUpdateTime(DateUtils.getNowDate());
        return tbBatchPlanMapper.updateTbBatchPlan(tbBatchPlan);
    }

    /**
     * 批量删除日常轮换计划
     *
     * @param ids 需要删除的日常轮换计划ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanByIds(Long[] ids)
    {
        return tbBatchPlanMapper.deleteTbBatchPlanByIds(ids);
    }

    /**
     * 删除日常轮换计划信息
     *
     * @param id 日常轮换计划ID
     * @return 结果
     */
    @Override
    public int deleteTbBatchPlanById(Long id)
    {
        return tbBatchPlanMapper.deleteTbBatchPlanById(id);
    }

    @Override
    public PageView<BatchPlanEntity> page(BatchPlanPageDto dto, Long organizeId, String organizeType ,Long lq) {
        PageHelper.startPage(dto.getCurrent(), dto.getPageSize());
        List<BatchPlanEntity> list = tbBatchPlanMapper.list(dto, organizeType, organizeId, lq);
        PageInfo<BatchPlanEntity> pageInfo = new PageInfo(list);
        return new PageView(pageInfo);
    }

    @Override
    public ResponseResult getBatchPlanById(Long id) {
        TbBatchPlan tbBatchPlan = tbBatchPlanMapper.selectTbBatchPlanById(id);

        if (BatchPlanStateEnum.DRAFT.getCode().equals(tbBatchPlan.getState())
                || BatchPlanStateEnum.NOT_GO.getCode().equals(tbBatchPlan.getState())
                || BatchPlanStateEnum.APPLY_APPROVE.getCode().equals(tbBatchPlan.getState())
                || BatchPlanStateEnum.COMPLETED.getCode().equals(tbBatchPlan.getState())
                || BatchPlanStateEnum.STOP.getCode().equals(tbBatchPlan.getState())){

            /* 1.若为草稿、申请待审批、审批不通过、已终止 状态时-按钮为：编辑 -> 获取相关信息*/
            BatchPlanInfo batchPlanInfo = tbBatchPlanInfoMapper.getBatchPlanInfoByBatchPlanId(id);
            List<BatchPlanDepotInfo> batchPlanDepotInfoList = tbBatchPlanDepotInfoMapper.getBatchPlanDepotInfoListByBatchPlanInfoId(batchPlanInfo.getId());
            batchPlanInfo.setBatchPlanDepotInfoList(batchPlanDepotInfoList);
            return ResponseResult.success(batchPlanInfo);

        }else if (BatchPlanStateEnum.APPROVAL_COMPLETE.getCode().equals(tbBatchPlan.getState())
                || BatchPlanStateEnum.STOP_APPROVE.getCode().equals(tbBatchPlan.getState())){

            /* 2.若为已审批、终止待审批时-按钮为：编辑 -> 获取相关信息*/
            BatchPlan batchPlanById = tbBatchPlanInfoMapper.getBatchPlanById(id);
            return ResponseResult.success(batchPlanById);

        }else if (BatchPlanStateEnum.ROTATE.getCode().equals(tbBatchPlan.getState())
                || BatchPlanStateEnum.CHANGE_APPROVE.getCode().equals(tbBatchPlan.getState())){
            /* 3.变更待审批、轮换中时-按钮为：编辑 -> 获取相关信息*/
            /**
             * String batchCode, String type, Double stockNum,
             *                      String grainDepotName, String stockTime,
             *                      Double totalOutNum, Double totalInNum, String remark
             */
            BatchPlan batchPlan = tbBatchPlanInfoMapper.getBatchPlanById(id);
            batchPlan.setBatchPlan(new BatchPlan(batchPlan.getBatchCode(),batchPlan.getType(),batchPlan.getStockNum(),batchPlan.getGrainDepotName(),
                    batchPlan.getStockTime(),batchPlan.getTotalOutNum(),batchPlan.getTotalInNum(),""));

            return ResponseResult.success(batchPlan);
        }else {
            throw new CustomException("状态异常，无此状态");
        }
    }

    /**
     * 终止已审批数据
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult terminateState(Long id) {
        int i = tbBatchPlanMapper.updateStateByStateAndId(id,"9");
        if (i>0){
            return ResponseResult.success();
        }else {
            return ResponseResult.error("终止失败，请重试");
        }
    }

    /**
     *日常轮换计划变更申请
     *
     * @param batchPlan
     * @return
     */
    @Override
    //@Transactional
    public ResponseResult changeRotate(BatchPlan batchPlan) {

        // 1.校验变更数量是否符合要求
        Map<String, Object> map = checkStock(batchPlan);
        if (map.get("status").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        /**
         * Long order, Long batchPlanId, Date removeBeginDate,
         * Date removeEndDate, Long outStock, String changeRemark, Date changeTime,
         * Long changeInTotal, Long changeOutTotal
         */
        // 2.将记录插入日常轮换计划变更表
        tbBatchPlanChangeMapper.insertTbBatchPlanChange(new TbBatchPlanChange(1L,batchPlan.getId(),new Date(),new Date(),batchPlan.getBatchPlan().getStockNum(),
                batchPlan.getBatchPlan().getRemark(),new Date(),batchPlan.getTotalInNum(),batchPlan.getTotalOutNum()));

        // 3.修改日常轮换计划的状态
        tbBatchPlanMapper.updateStateByStateAndId(batchPlan.getId(), "5");

        return ResponseResult.success();
    }

    @Override
    public ResponseResult getAnnualDetail(Long organizeId,String organizeType , Long lq) {
        // 通过组织id ， 粮权id ， 时间 ， 状态 ，是否删除 来获取数据
        // 1.获取当前年份的数据
        String yearStr = DateUtils.getYearStr(new Date());
        List<AnnualPlanForBatchPlan> annualPlanDetailList = tbBatchPlanMapper.getAnnualPlanDetail(organizeId, organizeType, lq, yearStr);

        List<AnnualPlanForBatchPlan> list = new ArrayList<>();
        for (AnnualPlanForBatchPlan plan : annualPlanDetailList){

            // TODO 计算实时库存比例

            list.add(plan);
        }


        return ResponseResult.success(list);
    }

    @Override
    public ResponseResult approveBatchPlan(Long id) {
        int i = tbBatchPlanMapper.approveBatchPlan(id, "");
        if (i>0){
            return ResponseResult.success();
        }else {
            return ResponseResult.error("审批失败");
        }
    }

    /**
     * 校验变更数量是否符合要求
     *
     * @param batchPlan
     * @return
     */
    private Map<String,Object> checkStock(BatchPlan batchPlan){
        Map<String,Object> map = new HashMap<>();
        map.put("status",false);
        map.put("msg","数据校验失败");

        Double stockNum = batchPlan.getBatchPlan().getStockNum();
        if ( stockNum > batchPlan.getStockNum() || stockNum < batchPlan.getTotalOutNum()){
            map.put("msg","变更计划数量应该小于原计划数量并且大于原计划累计轮出数量");
            return map;
        }

        map.put("status",true);
        map.put("msg","变更计划数量成功");

        return map;
    }

}
