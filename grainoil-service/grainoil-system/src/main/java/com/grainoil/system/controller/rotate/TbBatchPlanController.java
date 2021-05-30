package com.grainoil.system.controller.rotate;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.vo.rotate.BatchPlan;
import com.grainoil.system.domain.vo.rotate.BatchPlanEntity;
import com.grainoil.system.domain.vo.rotate.BatchPlanInfo;
import com.grainoil.system.domain.vo.rotate.dto.BatchPlanPageDto;
import com.grainoil.system.service.ITbBatchPlanInfoService;
import com.grainoil.system.service.ITbBatchPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("batchPlan")
@Api(value = "TbBatchPlanController", tags = "日常轮换计划管理")
public class TbBatchPlanController extends BaseController {
    @Autowired
    private ITbBatchPlanService tbBatchPlanService;
    @Autowired
    private ITbBatchPlanInfoService tbBatchPlanInfoService;

    /**
     * 查询日常轮换计划列表
     *
     * @param batchPlanPageDto 查询参数
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("日常轮换计划管理分页")
    public ResponseResult<PageView<BatchPlanEntity>> list(@RequestBody @Valid BatchPlanPageDto batchPlanPageDto)
    {
        PageView<BatchPlanEntity> page = tbBatchPlanService.page(batchPlanPageDto, getOrganizeId(), getOrganizeType() ,getLq());
        return ResponseResult.success(page);
    }

    /**
     *  申请日常轮换计划 -> 显示年度详情计划
     *
     * @param
     * @return
     */
    @GetMapping("/getAnnualPlanDetail")
    @ApiOperation("申请日常轮换计划视图显示")
    public ResponseResult getAnnualPlanDetail()
    {
        //申请按钮->返回年度数据给前端
        //TODO 未完成
        tbBatchPlanService.getAnnualDetail(getOrganizeId(),getOrganizeType(),getLq());
        return ResponseResult.success();
    }

    /**
     *  申请日常轮换计划 -> 显示年度详情计划
     *
     * @param
     * @return
     */
    @GetMapping("/addAnnualPlanDepotDetail")
    @ApiOperation("添加库存轮换清单列表")
    public ResponseResult addAnnualPlanDepotDetail()
    {
        //添加按钮->返回年度库存清单列表数据给前端
        //TODO 未完成
        tbBatchPlanService.getAnnualDetail(getOrganizeId(),getOrganizeType(),getLq());
        return ResponseResult.success();
    }


    /**
     * 列表操作列，通过id获取详细信息
     *
     * @param id
     * @return
     */
    @GetMapping("/updateBatchPlanDetail")
    @ApiOperation("日常轮换计划操作列")
    public ResponseResult updateBatchPlanDetail(Long id){
        ResponseResult result = tbBatchPlanService.getBatchPlanById(id);
        return result;
    }


    /**
     * 编辑日常轮换计划
     *
     * @param batchPlanInfo
     * @return
     */
    @PostMapping("/edit")
    @ApiOperation("编辑日常轮换计划")
    public ResponseResult edit(@RequestBody BatchPlanInfo  batchPlanInfo) {
        ResponseResult responseResult = tbBatchPlanInfoService.editBatchPlanInfo(batchPlanInfo);
        return responseResult;
    }

    /**
     * 申请日常轮换计划
     *
     * @param batchPlanInfo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("申请日常轮换计划")
    public ResponseResult add(@RequestBody BatchPlanInfo  batchPlanInfo) {
        ResponseResult responseResult = tbBatchPlanInfoService.addBatchPlanInfo(batchPlanInfo);
        return responseResult;
    }


    /**
     * 添加库存轮换清单列表
     *
     * @return
     */
    @GetMapping("/addBatchPlanDepotInfo")
    public ResponseResult addBatchPlanDepotInfo() {

        return null;
    }

    /**
     * 已审批->终止按钮操作
     *
     * @return
     */
    @GetMapping("/terminateState")
    @ApiOperation("终止已审批的数据")
    public ResponseResult terminateState(Long id) {
        ResponseResult responseResult = tbBatchPlanService.terminateState(id);
        return responseResult;
    }

    /**
     * 轮换中->变更按钮操作
     *
     * @return
     */
    @GetMapping("/changeRotate")
    @ApiOperation("变更轮换中的数据")
    public ResponseResult changeRotate(BatchPlan batchPlan) {
        ResponseResult responseResult = tbBatchPlanService.changeRotate(batchPlan);
        return responseResult;
    }

    /**
     * 审批按钮操作 - 当前只改状态
     *
     * @return
     */
    @GetMapping("/approve")
    @ApiOperation("审批按钮")
    public ResponseResult approve(Long id) {
        ResponseResult responseResult = tbBatchPlanService.approveBatchPlan(id);
        return responseResult;
    }
}
