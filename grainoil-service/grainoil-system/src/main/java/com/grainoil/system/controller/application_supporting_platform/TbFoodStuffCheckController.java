package com.grainoil.system.controller.application_supporting_platform;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.quality.FoodStuffCheckVo;
import com.grainoil.system.domain.vo.quality.VarietyCheckVo;
import com.grainoil.system.service.ITbFoodStuffCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/foodCheck")
@Api(value = "质检项配置",tags = "质检项配置")
public class TbFoodStuffCheckController extends BaseController {

    @Autowired
    ITbFoodStuffCheckService foodStuffCheckService;

    /**
     * 查询粮油品种列表
     */
    @ApiOperation("查询粮油品种列表")
    @GetMapping("/queryVariety")
    public ResponseResult<List<VarietyCheckVo>> queryVariety() {
        return ResponseResult.success(foodStuffCheckService.queryVariety());
    }

    /**
     * 编辑查看质检配置
     */
    @ApiOperation("编辑查看质检配置")
    @ApiImplicitParam(name = "varietyId", value = "粮油品种id", required = true)
    @GetMapping("/get/{varietyId}")
    public ResponseResult<FoodStuffCheckVo> get(@PathVariable("varietyId") Long varietyId) {
        CurrentUser currentUser = getCurrentUser();
        FoodStuffCheckVo foodStuffCheckVo= foodStuffCheckService.get(varietyId,currentUser);
        return ResponseResult.success(foodStuffCheckVo);
    }

    /**
     * 修改质检配置
     */
    @ApiOperation("修改质检配置")
    @PostMapping("/update")
    public ResponseResult update(@RequestBody @Valid FoodStuffCheckVo foodStuffCheckVo) {
        CurrentUser currentUser = getCurrentUser();
        foodStuffCheckService.update(foodStuffCheckVo,currentUser);
        return ResponseResult.success();
    }

}
