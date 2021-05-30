package com.grainoil.system.controller.repository_level;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.ImportStateEnum;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.vo.in_warehouse.*;
import com.grainoil.system.service.ITbInWarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("in")
@Api(tags = "入库管理")
public class ImportManagementController extends BaseController {

    @Autowired
    ITbInWarehouseService inWarehouseService;

    /**
     * 根据入库类型获取批文编号
     *
     * @param type 入库类型(数字字典)
     * @return 批文编号列表
     */
    @ApiOperation("根据入库类型获取批文编号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "入库类型(数字字典)", required = true)
    })
    @GetMapping("getBatchCode")
    public R getBatchCode(String type) {
        return inWarehouseService.getBatchCode(type, getOrganizeId());
    }

    /**
     * 根据批文编号id查询粮库,粮油品种,仓房的数据
     *
     * @param id 批文编号id
     * @return 结果
     */
    @ApiOperation("根据批文编号id查询粮库,粮油品种,仓房的数据(目前只适合招标入库)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "批文编号id", required = true),
            @ApiImplicitParam(name = "type", value = "入库类型(数字字典)", required = true)
    })
    @GetMapping("getData")
    public ResponseResult<List<DropDownVo>> getData(String type, Long id) {
        return inWarehouseService.getData(type, id);
    }

    /**
     * 保存入仓单
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @ApiOperation("保存入仓单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehousingType", value = "入库类型", required = true), @ApiImplicitParam(name = "inWarehouseCode", value = "入仓单编号", required = true),
            @ApiImplicitParam(name = "batchId", value = "批文编号id", required = true),
            @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true), @ApiImplicitParam(name = "storehouseId", value = "仓房id", required = true),
            @ApiImplicitParam(name = "quantity", value = "数量", required = true), @ApiImplicitParam(name = "varietyId", value = "粮食品种id", required = true),
            @ApiImplicitParam(name = "price", value = "购入价格", required = true), @ApiImplicitParam(name = "producingArea", value = "产地", required = true),
            @ApiImplicitParam(name = "producingProvince", value = "产地_省"), @ApiImplicitParam(name = "country", value = "国家"),
            @ApiImplicitParam(name = "particularYear", value = "生产年份", required = true), @ApiImplicitParam(name = "packing", value = "包装方式", required = true),
            @ApiImplicitParam(name = "packingMaterial", value = "包装材料", required = true), @ApiImplicitParam(name = "packingNumber", value = "包数", required = true),
            @ApiImplicitParam(name = "grade", value = "粮食等级", required = true), @ApiImplicitParam(name = "childVarieties", value = "小品种"),
            @ApiImplicitParam(name = "remark", value = "备注")
    })
    @PostMapping("save")
    public R save(@RequestBody @ApiIgnore TbInWarehouse inWarehouse) {
        if (getLq() == 0) {
            return R.error("没有粮权id");
        }
        inWarehouse.setCreateId(getCurrentUserId());
        inWarehouse.setCreateBy(getLoginName());
        inWarehouse.setUpdateId(getCurrentUserId());
        inWarehouse.setUpdateBy(getLoginName());
        inWarehouse.setOrganizeId(getOrganizeId());
        inWarehouse.setState("1");
        inWarehouse.setGrainOrganizeId(getLq());
        return inWarehouseService.insert(inWarehouse);
    }

    /**
     * 提交入仓单
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @ApiOperation("提交入仓单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehousingType", value = "入库类型", required = true), @ApiImplicitParam(name = "inWarehouseCode", value = "入仓单编号", required = true),
            @ApiImplicitParam(name = "batchId", value = "批文编号id", required = true),
            @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true), @ApiImplicitParam(name = "storehouseId", value = "仓房id", required = true),
            @ApiImplicitParam(name = "quantity", value = "数量", required = true), @ApiImplicitParam(name = "varietyId", value = "粮食品种id", required = true),
            @ApiImplicitParam(name = "price", value = "购入价格", required = true), @ApiImplicitParam(name = "producingArea", value = "产地", required = true),
            @ApiImplicitParam(name = "producingProvince", value = "产地_省"), @ApiImplicitParam(name = "country", value = "国家"),
            @ApiImplicitParam(name = "particularYear", value = "生产年份", required = true), @ApiImplicitParam(name = "packing", value = "包装方式", required = true),
            @ApiImplicitParam(name = "packingMaterial", value = "包装材料"), @ApiImplicitParam(name = "packingNumber", value = "包数"),
            @ApiImplicitParam(name = "grade", value = "粮食等级", required = true), @ApiImplicitParam(name = "childVarieties", value = "小品种"),
            @ApiImplicitParam(name = "remark", value = "备注")
    })
    @PostMapping("submit")
    public R submit(@RequestBody @ApiIgnore TbInWarehouse inWarehouse) {
        if (getLq() == 0) {
            return R.error("没有粮权id");
        }
        inWarehouse.setCreateId(getCurrentUserId());
        inWarehouse.setCreateBy(getLoginName());
        inWarehouse.setUpdateId(getCurrentUserId());
        inWarehouse.setUpdateBy(getLoginName());
        inWarehouse.setOrganizeId(getOrganizeId());
        inWarehouse.setState("2");
        inWarehouse.setGrainOrganizeId(getLq());
        inWarehouse.setApplyTime(new Date());
        return inWarehouseService.insert(inWarehouse);
    }

    /**
     * 根据条件查询入仓单列表
     *
     * @param inWarehouse 入仓单条件
     * @return 入仓单列表
     */
    @ApiOperation("根据条件查询入仓单列表")
    @PostMapping("list")
    public ResponseResult<PageView<InWarehouseListVo>> list(@RequestBody InWarehouseQuery inWarehouse) {
        return inWarehouseService.list(inWarehouse, getOrganizeType(), getOrganizeId(), getLq());
    }

    /**
     * 根据id获取入仓单信息
     *
     * @param id 入仓单id
     * @return 入仓单信息
     */
    @ApiOperation("根据id获取入仓单信息")
    @ApiImplicitParam(name = "id", value = "入仓单id", required = true)
    @GetMapping("get/{id}")
    public ResponseResult<InWarehouseVo> get(@PathVariable("id") Long id) {
        return inWarehouseService.get(id);
    }

    /**
     * 更新入仓单信息(保存)
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @ApiOperation("更新入仓单信息(保存)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehousingType", value = "入库类型", required = true), @ApiImplicitParam(name = "inWarehouseCode", value = "入仓单编号", required = true),
            @ApiImplicitParam(name = "batchId", value = "批文编号id", required = true),
            @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true), @ApiImplicitParam(name = "storehouseId", value = "仓房id", required = true),
            @ApiImplicitParam(name = "quantity", value = "数量", required = true), @ApiImplicitParam(name = "varietyId", value = "粮食品种id", required = true),
            @ApiImplicitParam(name = "price", value = "购入价格", required = true), @ApiImplicitParam(name = "producingArea", value = "产地", required = true),
            @ApiImplicitParam(name = "producingProvince", value = "产地_省"), @ApiImplicitParam(name = "country", value = "国家"),
            @ApiImplicitParam(name = "particularYear", value = "生产年份", required = true), @ApiImplicitParam(name = "packing", value = "包装方式", required = true),
            @ApiImplicitParam(name = "packingMaterial", value = "包装材料", required = true), @ApiImplicitParam(name = "packingNumber", value = "包数", required = true),
            @ApiImplicitParam(name = "grade", value = "粮食等级", required = true), @ApiImplicitParam(name = "childVarieties", value = "小品种"),
            @ApiImplicitParam(name = "remark", value = "备注"), @ApiImplicitParam(name = "id", value = "入仓单id", required = true)
    })
    @PostMapping("updateSave")
    public R updateSave(@RequestBody @ApiIgnore TbInWarehouse inWarehouse) {
        if (getLq() == 0) {
            return R.error("没有粮权id");
        }
        inWarehouse.setUpdateId(getCurrentUserId());
        inWarehouse.setUpdateBy(getLoginName());
        inWarehouse.setState("1");
        inWarehouse.setGrainOrganizeId(getLq());
        return inWarehouseService.updateSave(inWarehouse);
    }

    /**
     * 草稿提交或者不通过提交
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @ApiOperation("更新入仓单信息(提交)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehousingType", value = "入库类型", required = true), @ApiImplicitParam(name = "inWarehouseCode", value = "入仓单编号", required = true),
            @ApiImplicitParam(name = "batchId", value = "批文编号id", required = true),
            @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true), @ApiImplicitParam(name = "storehouseId", value = "仓房id", required = true),
            @ApiImplicitParam(name = "quantity", value = "数量", required = true), @ApiImplicitParam(name = "varietyId", value = "粮食品种id", required = true),
            @ApiImplicitParam(name = "price", value = "购入价格", required = true), @ApiImplicitParam(name = "producingArea", value = "产地", required = true),
            @ApiImplicitParam(name = "producingProvince", value = "产地_省"), @ApiImplicitParam(name = "country", value = "国家"),
            @ApiImplicitParam(name = "particularYear", value = "生产年份", required = true), @ApiImplicitParam(name = "packing", value = "包装方式", required = true),
            @ApiImplicitParam(name = "packingMaterial", value = "包装材料", required = true), @ApiImplicitParam(name = "packingNumber", value = "包数", required = true),
            @ApiImplicitParam(name = "grade", value = "粮食等级", required = true), @ApiImplicitParam(name = "childVarieties", value = "小品种"),
            @ApiImplicitParam(name = "remark", value = "备注"), @ApiImplicitParam(name = "id", value = "入仓单id", required = true)
    })
    @PostMapping("updateSubmit")
    public R updateSubmit(@RequestBody @ApiIgnore TbInWarehouse inWarehouse) {
        inWarehouse.setUpdateId(getCurrentUserId());
        inWarehouse.setUpdateBy(getLoginName());
        inWarehouse.setApplyTime(new Date());
        return inWarehouseService.updateSubmit(inWarehouse);
    }

    /**
     * 录入明细提交或者数据错误提交
     *
     * @param inWarehouse 入仓单明细信息
     * @return 结果
     */
    @ApiOperation("录入明细提交")
    @PostMapping("inputDetail")
    public ResponseResult inputDetail(@RequestBody @Valid InWarehouseDetailDto inWarehouse) {
        return inWarehouseService.inputDetail(inWarehouse, getCurrentUser());
    }

    /**
     * 审批
     *
     * @param approveDto 审批入参
     * @return 结果
     */
    @ApiOperation("审批")
    @PostMapping("approve")
    public ResponseResult approve(@Valid @RequestBody ApproveDto approveDto) {
        return inWarehouseService.approve(approveDto, getCurrentUser(), getRoleIds());
    }

    /**
     * 审核
     *
     * @param auditDto 审核入参
     * @return 结果
     */
    @PostMapping("audit")
    @ApiOperation("审核")
    public ResponseResult audit(@Valid @RequestBody AuditDto auditDto) {
        return inWarehouseService.audit(auditDto, getCurrentUser(), getRoleIds());
    }

    @ApiOperation("入仓单录入明细的添加按钮")
    @ApiImplicitParam(name = "id", value = "入仓通知单id", required = true)
    @GetMapping("getInsertButton/{id}")
    public ResponseResult<List<ListVo>> getInsertButton(@PathVariable("id") Long id) {
        return ResponseResult.success(inWarehouseService.getInsertButton(id));
    }
}
