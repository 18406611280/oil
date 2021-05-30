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
 * @Date: 2021/5/24 16:11
 */
@RestController
@RequestMapping("/deliverySampleQuality")
@Api(tags = "出库质检")
public class DeliverySampleQualityController extends BaseController {

    @Autowired
    private SampleQualityService sampleQualityService;

    @Autowired
    private GrainActualInventoryService grainActualInventoryService;

    /**
     * 分页
     */
    @ApiOperation("出库抽检分页")
    @PostMapping("/page")
    public ResponseResult<PageView<SampleQualityPageVo>> page(@RequestBody @Valid SamplePageDto samplePageDto){
        PageView<SampleQualityPageVo> pageVo = sampleQualityService.page(samplePageDto, QualityTypeEnum.OUT);
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
    @ApiOperation("保存出库质检")
    @PostMapping("/add")
    public ResponseResult addDeliveryQuality(@RequestBody @Valid DailySampleQualityAddDto addDto){
        CurrentUser currentUser = getCurrentUser();
        sampleQualityService.addDeliveryQuality(addDto,currentUser);
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
