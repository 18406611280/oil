package com.grainoil.system.controller.quality;

import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.quality.dto.SampleRegisterDto;
import com.grainoil.system.domain.quality.dto.SampleRegisterPageDto;
import com.grainoil.system.domain.vo.quality.SampleRegistrationDetailVo;
import com.grainoil.system.domain.vo.quality.SampleRegistrationPageVo;
import com.grainoil.system.service.SampleRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chenminghong
 * @Date: 2021/5/20 11:31
 */
@RestController
@RequestMapping("/sampleRegistration")
@Api(tags = "样品登记")
public class SampleRegistrationController {

    @Autowired
    private SampleRegistrationService sampleRegistrationService;

    /**
     * 分页
     */
    @ApiOperation("样品登记分页")
    @PostMapping("/page")
    public ResponseResult<PageView<SampleRegistrationPageVo>> page(@RequestBody SampleRegisterPageDto dto){
        PageView<SampleRegistrationPageVo> pageVo = sampleRegistrationService.page(dto);
        return ResponseResult.success(pageVo);

    }

    /**
     * 详情
     */
    @ApiOperation("样品登记详情")
    @GetMapping("/detail/{applyId}")
    @ApiImplicitParam(name = "applyId", value = "申请id", required = true)
    public ResponseResult<SampleRegistrationDetailVo> detail(@PathVariable Long applyId){
        SampleRegistrationDetailVo detailVo = sampleRegistrationService.detail(applyId);
        return ResponseResult.success(detailVo);
    }

    /**
     * 添加
     */
    @ApiOperation("录入样品")
    @PostMapping("/register")
    public ResponseResult<SampleRegistrationDetailVo> register(@RequestBody SampleRegisterDto dto){
        sampleRegistrationService.register(dto);
        return ResponseResult.success();
    }

}
