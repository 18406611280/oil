package com.grainoil.system.controller;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.system.domain.vo.quality.SampleInventoryVo;
import com.grainoil.system.domain.vo.rotate.InsertListVo;
import com.grainoil.system.service.GrainActualInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 13:47
 */
@RestController
@RequestMapping("/grainActualInventory")
@Api(tags = "粮库存储信息")
public class GrainActualInventoryController extends BaseController {

    @Autowired
    private GrainActualInventoryService grainActualInventoryService;

    /**
     * 查询粮油品种列表
     */
    @ApiOperation("查询粮油品种列表")
    @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true)
    @GetMapping("/queryVariety")
    public ResponseResult<List<SampleInventoryVo>> getSampleInventory(Long grainDepotId){
        CurrentUser currentUser = getCurrentUser();
        String organizeType = currentUser.getOrganizeType();
        if(!organizeType.equals(OrganizeTypeEnum.COMPANY.code)){
            return ResponseResult.error("只有存储企业人员才可获取粮油品种列表!");
        }
        List<SampleInventoryVo> sampleInventoryVoList = grainActualInventoryService.getSampleInventory(grainDepotId,currentUser);
        return ResponseResult.success(sampleInventoryVoList);
    }

    @ApiOperation("申请年度计划时添加按钮的列表")
    @GetMapping("getInsert")
    public ResponseResult<List<InsertListVo>> getInsert() {
        return ResponseResult.success(grainActualInventoryService.getInsert(getOrganizeId()));
    }

}
