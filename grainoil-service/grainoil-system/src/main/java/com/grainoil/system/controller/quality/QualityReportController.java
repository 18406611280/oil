package com.grainoil.system.controller.quality;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.quality.dto.QualityReportAddDto;
import com.grainoil.system.domain.quality.dto.QualityReportPageDto;
import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import com.grainoil.system.domain.vo.quality.QualityReportPageVo;
import com.grainoil.system.domain.vo.quality.SampleQualityDetailVo;
import com.grainoil.system.service.QualityReportService;
import com.grainoil.system.service.SampleApplicationService;
import com.grainoil.system.service.SampleQualityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 14:50
 */
@RestController
@RequestMapping("/qualityReport")
@Api(tags = "质检报告")
public class QualityReportController {

    @Autowired
    private QualityReportService qualityReportService;

    @Autowired
    private SampleQualityService sampleQualityService;

    @Autowired
    private SampleApplicationService sampleApplicationService;

    /**
     * 分页
     */
    @ApiOperation("分页")
    @PostMapping("/page")
    public ResponseResult<PageView<QualityReportPageVo>> page(@RequestBody QualityReportPageDto dto){
        PageView<QualityReportPageVo> pageVo = qualityReportService.page(dto);
        return ResponseResult.success(pageVo);
    }

    /**
     * 录入查看页面
     */
    @ApiOperation("录入查看页面")
    @GetMapping("/inputResult/{sampleId}")
    @ApiImplicitParam(name = "sampleId", value = "样品id", required = true)
    public ResponseResult<SampleQualityDetailVo> inputResult(@PathVariable Long sampleId){
        SampleQualityDetailVo detailVo = sampleQualityService.detail(sampleId);
        return ResponseResult.success(detailVo);
    }

    /**
     * 保存
     */
    @ApiOperation("保存质检信息")
    @PostMapping("/add")
    public ResponseResult addQualityReport(@RequestBody @Valid QualityReportAddDto addDto){
        Long sampleId = addDto.getSampleId();
        List<FoodCheckItemVo> foodCheckItemVos = addDto.getFoodCheckItemVos();
        sampleApplicationService.saveCheckResult(sampleId,foodCheckItemVos);
        return ResponseResult.success();
    }


}
