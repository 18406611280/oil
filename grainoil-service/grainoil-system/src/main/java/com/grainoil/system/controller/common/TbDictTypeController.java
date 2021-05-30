package com.grainoil.system.controller.common;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.system.domain.TbDictType;
import com.grainoil.system.service.ITbDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 数字字典类型
 */
@RestController
@RequestMapping("dict/type")
@Api(tags = "数字字典类型")
public class TbDictTypeController extends BaseController {

    @Autowired
    private ITbDictTypeService tbDictTypeService;

    /**
     * 查询字典类型
     */
    @GetMapping("get/{dictId}")
    @ApiOperation(value = "根据id获取字典信息", notes = "根据id获取字典信息")
    @ApiImplicitParam(name = "dictId", value = "字典类型id", required = true)
    public TbDictType get(@PathVariable("dictId") Long dictId) {
        return tbDictTypeService.selectDictTypeById(dictId);
    }

    /**
     * 查询字典类型列表
     */
    @GetMapping("list")
//    @HasPermissions("system:dict:list")
    @ApiOperation("查询字典类型列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "dictType", value = "字典类型"),@ApiImplicitParam(name = "dictName", value = "字典名称")})
    public R list(TbDictType tbDictType) {
        startPage();
        return result(tbDictTypeService.selectDictTypeList(tbDictType));
    }


    /**
     * 新增保存字典类型
     */
//    @OperLog(title = "字典类型", businessType = BusinessType.INSERT)
//    @HasPermissions("system:dict:add")
    @PostMapping("save")
    @ApiOperation(value = "新增保存字典类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "dictType", value = "字典类型", required = true),@ApiImplicitParam(name = "dictName", value = "字典名称", required = true)})
    public R addSave(@RequestBody TbDictType tbDictType) {
        tbDictType.setCreateId(getCurrentUserId());
        tbDictType.setUpdateId(getCurrentUserId());
        tbDictType.setCreateBy(getLoginName());
        tbDictType.setUpdateBy(getLoginName());
        return tbDictTypeService.insertDictType(tbDictType);
    }

    /**
     * 修改保存字典类型
     */
//    @OperLog(title = "字典类型", businessType = BusinessType.UPDATE)
//    @HasPermissions("system:dict:edit")
    @PostMapping("update")
    @ApiOperation("修改保存字典类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "字典类型", required = true),@ApiImplicitParam(name = "dictName", value = "字典名称", required = true),
            @ApiImplicitParam(name = "dictId", value = "id", required = true),@ApiImplicitParam(name = "status", value = "状态（0正常 1停用）", required = true),
            @ApiImplicitParam(name = "remark", value = "备注", required = true)
    })
    public R editSave(@RequestBody TbDictType tbDictType) {
        tbDictType.setUpdateId(getCurrentUserId());
        tbDictType.setUpdateBy(getLoginName());
        return tbDictTypeService.updateDictType(tbDictType);
    }

    /**
     * 批量删除字典类型
     */
//    @OperLog(title = "字典类型", businessType = BusinessType.DELETE)
//    @HasPermissions("system:dict:remove")
    @PostMapping("remove")
    @ApiOperation("批量删除字典类型")
    @ApiImplicitParam(name = "ids", value = "id集合(以','隔开)", required = true)
    public R remove(String ids) {
        return toAjax(tbDictTypeService.deleteDictTypeByIds(ids));
    }
}
