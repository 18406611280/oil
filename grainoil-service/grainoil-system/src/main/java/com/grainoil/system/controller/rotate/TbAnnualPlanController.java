package com.grainoil.system.controller.rotate;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.TbAnnualPlan;
import com.grainoil.system.domain.vo.rotate.AnnualPlanListVo;
import com.grainoil.system.domain.vo.rotate.InsertListVo;
import com.grainoil.system.domain.vo.rotate.dto.AnnualPlanDto;
import com.grainoil.system.domain.vo.rotate.dto.AnnualPlanOperaDto;
import com.grainoil.system.service.ITbAnnualPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/20 10:57
 */
@RestController
@RequestMapping("annualPlan")
@Api(tags = "年度轮换计划管理")
public class TbAnnualPlanController extends BaseController {

    @Autowired
    ITbAnnualPlanService annualPlanService;

    @ApiOperation("查询年度轮换计划列表")
    @GetMapping("list")
    public ResponseResult<List<AnnualPlanListVo>> list(AnnualPlanDto dto) {
        return ResponseResult.success(annualPlanService.list(dto, getOrganizeType(), getOrganizeId(), getLq()));
    }


    @ApiOperation("添加/编辑/调增年度轮换计划")
    @PostMapping("insert")
    public ResponseResult insert(@Valid @RequestBody AnnualPlanOperaDto dto) {
//        return annualPlanService.insert();
        return ResponseResult.error();
    }

    @ApiOperation("点击申请按钮时获取标题的前缀")
    @GetMapping("getPrefix")
    public ResponseResult getPrefix() {
        return annualPlanService.getPrefix(getLq());
    }

    @ApiOperation("查看年度轮换计划")
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable("id") Long id) {
        return null;
    }

    @ApiOperation("审批")
    @PostMapping("approve")
    public ResponseResult approve() {
        return ResponseResult.success();
    }


}
