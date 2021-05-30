package com.grainoil.system.controller.quality;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.system.domain.quality.dto.DailySampleQualityAddDto;
import com.grainoil.system.domain.quality.dto.InventoryDto;
import com.grainoil.system.domain.quality.dto.SamplePageDto;
import com.grainoil.system.domain.vo.quality.GrainInventoryVo;
import com.grainoil.system.domain.vo.quality.SampleQualityDetailVo;
import com.grainoil.system.domain.vo.quality.SampleQualityPageVo;
import com.grainoil.system.service.GrainActualInventoryService;
import com.grainoil.system.service.SampleQualityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: chenminghong
 * @Date: 2021/5/21 16:11
 */
@RestController
@RequestMapping("/dailySampleQuality")
@Api(tags = "日常抽检")
public class DailySampleQualityController extends BaseController {

    @Autowired
    private SampleQualityService sampleQualityService;

    @Autowired
    private GrainActualInventoryService grainActualInventoryService;

    /**
     * 日常抽检分页
     */
    @ApiOperation("日常抽检分页")
    @PostMapping("/page")
    public ResponseResult<PageView<SampleQualityPageVo>> page(@RequestBody @Valid SamplePageDto samplePageDto){
        PageView<SampleQualityPageVo> pageVo = sampleQualityService.page(samplePageDto, QualityTypeEnum.DAY);
        return ResponseResult.success(pageVo);
    }

    /**
     * 查询粮油品种
     */
    @ApiOperation("查询粮油品种")
    @PostMapping("/getInventory")
    public ResponseResult<GrainInventoryVo> getInventory(@RequestBody @Valid InventoryDto inventoryDto){
        CurrentUser currentUser = getCurrentUser();
        GrainInventoryVo grainInventoryVo = grainActualInventoryService.getInventory(inventoryDto,currentUser);
        return ResponseResult.success(grainInventoryVo);
    }

    /**
     * 保存
     */
    @ApiOperation("保存日常抽检")
    @PostMapping("/add")
    public ResponseResult addDailyQuality(@RequestBody @Valid DailySampleQualityAddDto addDto){
        CurrentUser currentUser = getCurrentUser();
        sampleQualityService.addDailyQuality(addDto,currentUser);
        return ResponseResult.success();
    }

    /**
     * 详情
     */
    @ApiOperation("查看详情")
    @GetMapping("/detail/{sampleId}")
    @ApiImplicitParam(name = "sampleId", value = "样品id", required = true)
    public ResponseResult<SampleQualityDetailVo> detail(@PathVariable Long sampleId){
        SampleQualityDetailVo detailVo = sampleQualityService.detail(sampleId);
        return ResponseResult.success(detailVo);
    }


}
