package com.grainoil.system.controller.common;

import com.grainoil.common.auth.annotation.HasPermissions;
import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.log.annotation.OperLog;
import com.grainoil.common.log.enums.BusinessType;
import com.grainoil.system.domain.TbDictData;
import com.grainoil.system.service.ITbDictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数字字典数据
 */
@RestController
@RequestMapping("dict/data")
@Api(tags = "数字字典数据")
public class TbDictDataController extends BaseController {
	
	@Autowired
	private ITbDictDataService tbDictDataService;
	
	/**
	 * 查询字典数据
	 */
	@ApiOperation("查询字典数据")
	@ApiImplicitParam(name = "dictCode", value = "字典编码(id)", required = true)
	@GetMapping("get/{dictCode}")
	public TbDictData get(@PathVariable("dictCode") Long dictCode) {
		return tbDictDataService.selectDictDataById(dictCode);
	}
	
	/**
	 * 查询字典数据列表
	 */
	@GetMapping("list")
	@ApiOperation("查询字典数据列表")
	@ApiImplicitParams({@ApiImplicitParam(name = "dictType", value = "字典类型"),@ApiImplicitParam(name = "dictLabel", value = "字典标签"),@ApiImplicitParam(name = "status", value = "状态（0正常 1停用）")})
//	@HasPermissions("system:dict:list")
	public R list(TbDictData dictData) {
		startPage();
        return result(tbDictDataService.selectDictDataList(dictData));
	}
	
	/**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
	@GetMapping("type")
	@ApiOperation("根据字典类型查询字典数据信息")
	@ApiImplicitParam(name = "dictType", value = "字典类型(英文)", required = true)
    public List<TbDictData> getType(String dictType) {
        return tbDictDataService.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @ApiOperation("根据字典类型和字典键值查询字典数据信息")
	@ApiImplicitParams({@ApiImplicitParam(name = "dictType", value = "字典类型(英文)", required = true),@ApiImplicitParam(name = "dictValue", value = "字典键值", required = true)})
	@GetMapping("label")
    public String getLabel(String dictType, String dictValue) {
        return tbDictDataService.selectDictLabel(dictType, dictValue);
    }
	
	
	/**
	 * 新增保存字典数据
	 */
//	@OperLog(title = "字典数据", businessType = BusinessType.INSERT)
//    @HasPermissions("system:dict:add")
	@PostMapping("save")
	@ApiOperation("新增保存字典数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dictSort", value = "字典排序(可空)", required = true),@ApiImplicitParam(name = "dictLabel", value = "字典标签", required = true),
			@ApiImplicitParam(name = "dictValue", value = "字典键值", required = true),@ApiImplicitParam(name = "dictType", value = "字典类型id", required = true),
			@ApiImplicitParam(name = "remark", value = "备注(可空)", required = true)
	})
	public R addSave(@RequestBody TbDictData tbDictData) {
		tbDictData.setCreateId(getCurrentUserId());
		tbDictData.setUpdateId(getCurrentUserId());
		tbDictData.setCreateBy(getLoginName());
		tbDictData.setUpdateBy(getLoginName());
		return tbDictDataService.insertDictData(tbDictData);
	}

	/**
	 * 修改保存字典数据
	 */
//	@OperLog(title = "字典数据", businessType = BusinessType.UPDATE)
//    @HasPermissions("system:dict:edit")
	@PostMapping("update")
	@ApiOperation("修改保存字典数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dictSort", value = "字典排序", required = true),@ApiImplicitParam(name = "dictLabel", value = "字典标签", required = true),
			@ApiImplicitParam(name = "dictValue", value = "字典键值", required = true),@ApiImplicitParam(name = "status", value = "状态（0正常 1停用）", required = true),
			@ApiImplicitParam(name = "dictType", value = "字典类型id", required = true),
			@ApiImplicitParam(name = "remark", value = "备注", required = true),@ApiImplicitParam(name = "dictCode", value = "字典编码", required = true)
	})
	public R editSave(@RequestBody TbDictData tbDictData) {
		tbDictData.setUpdateId(getCurrentUserId());
		tbDictData.setUpdateBy(getLoginName());
		return tbDictDataService.updateDictData(tbDictData);
	}
	
	/**
	 * 批量删除字典数据
	 */
//	@OperLog(title = "字典数据", businessType = BusinessType.DELETE)
//    @HasPermissions("system:dict:remove")
	@PostMapping("remove")
	@ApiOperation("批量删除字典数据")
	@ApiImplicitParam(name = "ids", value = "id集合(以','隔开)", required = true)
	public R remove(String ids) {
		return toAjax(tbDictDataService.deleteDictDataByIds(ids));
	}
	
}
