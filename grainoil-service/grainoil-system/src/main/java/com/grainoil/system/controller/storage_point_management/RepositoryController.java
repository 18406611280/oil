package com.grainoil.system.controller.storage_point_management;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.point_management.*;
import com.grainoil.system.service.ITbGrainDepotService;
import com.grainoil.system.service.ITbPileService;
import com.grainoil.system.service.ITbStorehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("repository")
@Api(value = "RepositoryController", tags = "承储库点管理")
public class RepositoryController extends BaseController {

    @Autowired
    ITbGrainDepotService grainDepotService;

    @Autowired
    ITbStorehouseService storehouseService;

    @Autowired
    ITbPileService pileService;

    /**
     * 获取所有的粮库下拉框
     *
     * @return 粮库下拉框
     */
    @ApiOperation("获取所有的粮库下拉框")
    @GetMapping("getGrainDepots")
    public ResponseResult<List<Map<String, Object>>> getGrainDepots() {
        return ResponseResult.success(grainDepotService.getGrainDepots());
    }

    /**
     * 添加粮库信息
     *
     * @param depot 粮库信息
     * @return ok/error
     */
    @ApiOperation("添加粮库信息")
    @PostMapping("grainDepot/insert")
    public ResponseResult gInsert(@RequestBody @Valid GrainDepotInsert depot) {
        return grainDepotService.insert(depot, getCurrentUser());
    }

    /**
     * 根据条件查询粮库列表信息
     *
     * @param depot 粮库查询条件
     * @return 结果
     */
    @ApiOperation("根据条件查询粮库列表信息")
    @PostMapping("grainDepot/list")
    public ResponseResult<List<GrainDepotListVo>> gList(GrainDepotQueryVo depot) {
        return grainDepotService.list(depot, getOrganizeId(), getOrganizeType());
    }

    /**
     * 获取修改时的粮库信息
     *
     * @param grainDepotId 粮库id
     * @return 结果
     */
    @ApiOperation("根据id获取修改时的粮库信息")
    @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true)
    @GetMapping("grainDepot/getUpdate/{grainDepotId}")
    public ResponseResult<GrainDepotGet> gGetUpdate(@PathVariable("grainDepotId") Long grainDepotId) {
        return grainDepotService.getUpdate(grainDepotId, getOrganizeId(), getOrganizeType());
    }

    /**
     * 修改粮库信息
     *
     * @param depot 粮库信息
     * @return 结果
     */
    @ApiOperation("修改粮库信息")
    @PostMapping("grainDepot/update")
    public ResponseResult gUpdate(@RequestBody @Valid GrainDepotUpdate depot) {
        return grainDepotService.update(depot, getCurrentUser(), getOrganizeId(), getOrganizeType());
    }

    /**
     * 添加仓房
     * @param storehouse 仓房信息
     * @return 结果
     */
    @ApiOperation("添加仓房")
    @PostMapping("storehouse/insert")
    public ResponseResult sInsert(@RequestBody @Valid StorehouseVo storehouse) {
        return storehouseService.insert(storehouse, getCurrentUser());
    }

    /**
     * 根据粮库id查询仓房下拉框
     *
     * @param grainDepotId 粮库id
     * @return 仓房列表
     */
    @ApiOperation("根据粮库id查询仓房下拉框")
    @ApiImplicitParam(name = "grainDepotId", value = "粮库id", required = true)
    @GetMapping("storehouse/search")
    public ResponseResult<List<Map<String,Object>>> sSearch(@RequestParam("grainDepotId") Long grainDepotId) {
        return ResponseResult.success(storehouseService.search(grainDepotId, getOrganizeType(), getOrganizeId()));
    }

    /**
     * 根据条件查询仓房列表信息
     *
     * @param storehouse 仓房信息
     * @return 结果
     */
    @ApiOperation("根据条件查询仓房列表信息")
    @GetMapping("storehouse/list")
    public ResponseResult<List<StorehouseListVo>> sList(StorehouseQuery storehouse) {
        return storehouseService.list(storehouse, getOrganizeType(), getOrganizeId());
    }

    /**
     * 根据id获取仓房信息
     *
     * @param id 仓房id
     * @return 仓房信息
     */
    @ApiOperation("根据id获取仓房信息")
    @ApiImplicitParam(name = "id", value = "仓房id", required = true)
    @GetMapping("storehouse/getUpdate/{id}")
    public ResponseResult<StorehouseGet> sGetUpdate(@PathVariable("id") Long id) {
        return storehouseService.getUpdate(id, getOrganizeType(), getOrganizeId());
    }

    /**
     * 修改仓房信息
     *
     * @param storehouse 仓房信息
     * @return 结果
     */
    @ApiOperation("修改仓房信息")
    @PostMapping("storehouse/update")
    public ResponseResult sUpdate(@RequestBody @Valid StorehouseVo storehouse) {
        return storehouseService.update(storehouse, getCurrentUser());
    }

    /**
     * 添加堆位信息
     *
     * @param pile 堆位信息
     * @return 结果
     */
    @ApiOperation("添加堆位信息")
    @PostMapping("pile/insert")
    public ResponseResult pInsert(@RequestBody @Valid PileVo pile) {
        return pileService.insert(pile, getCurrentUser());
    }

    /**
     * 根据id获取堆位信息
     *
     * @param id 堆位id
     * @return 结果
     */
    @ApiOperation("根据id获取堆位信息")
    @ApiImplicitParam(name = "id", value = "堆位id", required = true)
    @GetMapping("pile/getUpdate/{id}")
    public ResponseResult<PileVo> pGetUpdate(@PathVariable("id") Long id) {
        return pileService.getUpdate(id, getOrganizeId(), getOrganizeType());
    }

    /**
     * 修改堆位信息
     *
     * @param pile 堆位信息
     * @return 结果
     */
    @ApiOperation("修改堆位信息")
    @PostMapping("pile/update")
    public ResponseResult pUpdate(@RequestBody @Valid PileVo pile) {
        return pileService.update(pile, getCurrentUser());
    }

    /**
     * 根据条件查询堆位列表
     *
     * @param pile 堆位信息
     * @return 堆位列表
     */
    @ApiOperation("根据条件查询堆位列表")
    @GetMapping("pile/list")
    public ResponseResult<List<PileListVo>> pList(@Valid PileQueryVo pile) {
        return pileService.list(pile, getOrganizeType(), getOrganizeId());
    }

    @ApiOperation("能否拆堆")
    @GetMapping("pile/canSplit/{id}")
    public ResponseResult pCanSplit(@PathVariable("id") Long id) {
        return pileService.canSplit(id);
    }

    @PostMapping("pile/split")
    @ApiOperation("拆堆")
    public ResponseResult pSplit(@Valid @RequestBody PileSplitDto splitDto) {
        return pileService.split(splitDto, getCurrentUser());
    }

    @PostMapping("pile/combine")
    @ApiImplicitParam(name = "id", value = "堆位id", required = true)
    @ApiOperation("合堆")
    public ResponseResult pCombine(@RequestParam Long id) {
        return pileService.combine(id, getCurrentUser());
    }

    /**
     * 添加存储合同添加明细表的添加按钮
     *
     * @param id 粮库id
     * @return 数据列表
     */
    @ApiOperation("添加存储合同添加明细表的添加按钮")
    @ApiImplicitParam(name = "id", value = "粮库id(没有粮库选择时用'0')")
    @GetMapping("getStorageDetailList/{id}")
    public ResponseResult<List<Map<String,Object>>> getStorageDetailList(@PathVariable("id") Long id) {
        return ResponseResult.success(grainDepotService.getStorageDetailList(id));
    }

    /**
     * 仓房所属企业修改时使用企业的添加按钮
     *
     * @return
     */
    @ApiOperation("仓房所属企业修改时使用企业的添加按钮")
    @GetMapping("storehouse/getOrganizeVo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "粮库id", required = true), @ApiImplicitParam(name = "organizeId", value = "组织id")
    })
    public ResponseResult<List<OrganizeVo>> getOrganizeVo(Long id, Long organizeId) {
        return ResponseResult.success(storehouseService.getOrganizeVo(id, organizeId, getOrganizeId()));
    }

    /**
     * 仓房所属企业修改时使用企业的添加按钮中的组织下拉框
     *
     * @param id 所属粮库id
     * @return 组织名称列表
     */
    @ApiOperation("仓房所属企业修改时使用企业的添加按钮中的组织下拉框")
    @GetMapping("storehouse/getOrganizeVoSelect/{id}")
    @ApiImplicitParam(name = "id", value = "粮库id", required = true)
    public ResponseResult<List<OrganizeVo>> getOrganizeVoSelect(@PathVariable("id") Long id) {
        return ResponseResult.success(storehouseService.getOrganizeVoSelect(id));
    }

}
