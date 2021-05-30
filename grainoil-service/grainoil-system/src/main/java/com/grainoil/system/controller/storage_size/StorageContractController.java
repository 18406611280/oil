package com.grainoil.system.controller.storage_size;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.TbStorageContract;
import com.grainoil.system.domain.vo.storage_contract.StorageContractVo;
import com.grainoil.system.service.ITbStorageContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("storageContract")
@Api(tags = "存储合同")
public class StorageContractController extends BaseController {

    @Autowired
    ITbStorageContractService storageContractService;

    /**
     * 添加存储合同以及明细
     *
     * @param storageContract 存储合同信息
     * @return 结果
     */
    @ApiOperation("添加存储合同以及明细")
    @PostMapping("insert")
    public ResponseResult insert(@RequestBody @Valid StorageContractVo storageContract) {
        return storageContractService.insert(storageContract, getCurrentUser());
    }

    /**
     * 根据条件查询存储合同列表数据
     *
     * @param map 查询列表条件
     * @return 列表数据
     */
    @ApiOperation("根据条件查询存储合同列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "belongId", value = "承储企业id(当组织类型为'5'时这个字段有无都行,因为没用到)"),@ApiImplicitParam(name = "region", value = "粮库所在区"),
            @ApiImplicitParam(name = "varietyId", value = "粮油品种id"),@ApiImplicitParam(name = "grainDepotId", value = "粮库id"),
            @ApiImplicitParam(name = "begin", value = "承储周期开始(yyyy-MM-dd)"),@ApiImplicitParam(name = "end", value = "承储周期结束(yyyy-MM-dd)"),
            @ApiImplicitParam(name = "state", value = "合同状态"),@ApiImplicitParam(name = "code", value = "承储合同编号")
    })
    @PostMapping("list")
    public R list(@RequestBody @ApiIgnore Map<String, Object> map) {
        startPage();
        return result(storageContractService.list(map, getOrganizeType(), getOrganizeId()));
    }

    /**
     * 根据id查询合同信息
     *
     * @param id id
     * @return 结果
     */
    @ApiOperation("根据id查询合同信息")
    @ApiImplicitParam(name = "id", value = "合同id", required = true)
    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id) {
        return storageContractService.get(id);
    }
}
