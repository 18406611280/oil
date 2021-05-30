package com.grainoil.system.controller.application_supporting_platform;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.TbVariety;
import com.grainoil.system.domain.vo.variety.VarietyVo;
import com.grainoil.system.service.ITbVarietyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("variety")
@Api(tags = "粮油品种管理", value = "TbVarietyController")
public class TbVarietyController extends BaseController {

    @Autowired
    ITbVarietyService varietyService;

    /**
     * 查询粮油品种列表
     *
     * @return 结果
     */
    @ApiOperation("查询粮油品种列表")
    @GetMapping("list")
    public ResponseResult list() {
        return ResponseResult.success(varietyService.list());
    }

    /**
     * 添加粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return ok/error
     */
    @ApiOperation("添加粮油品种信息")
    @PostMapping("insert")
    public ResponseResult insert(@RequestBody @Valid VarietyVo varietyVo) {
        return varietyService.insert(varietyVo, getCurrentUser());
    }

    /**
     * 修改粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return ok/error
     */
    @ApiOperation("修改粮油品种信息")
    @PostMapping("update")
    public ResponseResult update(@RequestBody @Valid VarietyVo varietyVo) {
        return varietyService.update(varietyVo, getCurrentUser());
    }

    /**
     * 根据id查询粮油品种信息
     *
     * @param id 粮油品种id
     * @return 粮油品种信息
     */
    @ApiOperation("根据id查询粮油品种信息")
    @ApiImplicitParam(name = "id", value = "粮油品种id", required = true)
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable("id") Long id) {
        return varietyService.get(id);
    }

    /**
     * 根据id删除粮油品种信息
     *
     * @param id 粮油品种id
     * @return 结果
     */
    @ApiOperation("根据id删除粮油品种信息")
    @ApiImplicitParam(name = "id", value = "粮油品种id", required = true)
    @GetMapping("delete/{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        TbVariety tbVariety = new TbVariety();
        tbVariety.setUpdateId(getCurrentUserId());
        tbVariety.setUpdateBy(getLoginName());
        tbVariety.setVarietyId(id);
        return varietyService.delete(tbVariety);
    }

    /**
     * 获取粮油品种下拉框列表
     *
     * @return 粮油品种下拉框
     */
    @ApiOperation("获取粮油品种下拉框列表")
    @GetMapping("getSelect")
    public ResponseResult getSelect() {
        return varietyService.getSelect();
    }
}
