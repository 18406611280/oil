package com.grainoil.system.controller.quality;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.QualityApplyStatusEnum;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.system.domain.quality.TbQualityApply;
import com.grainoil.system.domain.quality.dto.SampleApplyDto;
import com.grainoil.system.domain.quality.dto.SampleApplyEditDto;
import com.grainoil.system.domain.quality.dto.SampleApplyPageDto;
import com.grainoil.system.domain.quality.dto.SampleDto;
import com.grainoil.system.domain.vo.quality.QualityApplyDetailVo;
import com.grainoil.system.domain.vo.quality.SampleInformationVo;
import com.grainoil.system.domain.vo.quality.SampleQualityApplyPageVo;
import com.grainoil.system.service.GrainActualInventoryService;
import com.grainoil.system.service.SampleApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 11:50
 */

@RestController
@RequestMapping("/sampleApplication")
@Api(tags = "入库质检扦样申请")
public class SampleApplicationController extends BaseController {

    @Autowired
    private SampleApplicationService sampleApplicationService;

    @Autowired
    private GrainActualInventoryService grainActualInventoryService;

    /**
     * 入库扦样申请基础信息
     */
    @ApiOperation("扦样申请基础信息")
    @GetMapping("/information")
    public ResponseResult<SampleInformationVo> information(){
        CurrentUser currentUser = getCurrentUser();
        SampleInformationVo sampleInformationVo = sampleApplicationService.getSampleInformation(currentUser);
        return ResponseResult.success(sampleInformationVo);
    }

    /**
     * 质检员接收
     */
    @ApiOperation("接收")
    @GetMapping("/receive/{applyId}")
    @ApiImplicitParam(name = "applyId", value = "申请id", required = true)
    public ResponseResult receive(@PathVariable("applyId") Long applyId){
        CurrentUser currentUser = getCurrentUser();
        sampleApplicationService.receive(applyId);
        return ResponseResult.success();
    }


    /**
     * 扦样申请保存
     */
    @ApiOperation("扦样申请保存")
    @PostMapping("/saveApply")
    public ResponseResult saveApply(@RequestBody SampleApplyDto sampleApplyDto){
        CurrentUser currentUser = getCurrentUser();
        TbQualityApply qualityApply = sampleApplicationService.saveQualityApply(sampleApplyDto, currentUser, QualityTypeEnum.IN, QualityApplyStatusEnum.DRAFT.code);
        List<SampleDto> sampleDtoList = sampleApplyDto.getSampleDtoList();
        for (SampleDto sampleDto : sampleDtoList) {
            sampleApplicationService.saveQualityApplyDetail(qualityApply, sampleDto);
        }
        return ResponseResult.success();
    }

    /**
     * 扦样申请提交
     */
    @ApiOperation("扦样申请提交")
    @PostMapping("/submitApply")
    public ResponseResult submitApply(@RequestBody SampleApplyDto sampleApplyDto){
        CurrentUser currentUser = getCurrentUser();
        TbQualityApply qualityApply = sampleApplicationService.saveQualityApply(sampleApplyDto, currentUser, QualityTypeEnum.IN, QualityApplyStatusEnum.PENDING_APPROVAL.code);
        List<SampleDto> sampleDtoList = sampleApplyDto.getSampleDtoList();
        for (SampleDto sampleDto : sampleDtoList) {
            sampleApplicationService.saveQualityApplyDetail(qualityApply, sampleDto);
        }
        return ResponseResult.success();
    }

    /**
     * 扦样申请分页
     */
    @ApiOperation("扦样申请分页")
    @PostMapping("/page")
    public ResponseResult<PageView<SampleQualityApplyPageVo>> page(@RequestBody SampleApplyPageDto sampleApplyPageDto){
        PageView<SampleQualityApplyPageVo> pageVo = sampleApplicationService.page(sampleApplyPageDto);
        return ResponseResult.success(pageVo);
    }

    /**
     * 扦样申请详情页面
     */
    @ApiOperation("扦样申请详情页面")
    @GetMapping("/getApplyDetail/{id}")
    public ResponseResult<QualityApplyDetailVo> getApplyDetail(@PathVariable Long id){
        QualityApplyDetailVo qualityApplyDetailVo= sampleApplicationService.getApplyDetail(id);
        return ResponseResult.success(qualityApplyDetailVo);
    }

    /**
     * 扦样申请修改保存
     */
    @ApiOperation("扦样申请修改保存")
    @PostMapping("/editApply")
    public ResponseResult<QualityApplyDetailVo> editApply(@PathVariable SampleApplyEditDto applyEditDto){
        sampleApplicationService.editApply(applyEditDto);
        return ResponseResult.success();
    }


}
