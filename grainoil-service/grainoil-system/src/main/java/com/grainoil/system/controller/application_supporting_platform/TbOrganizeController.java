package com.grainoil.system.controller.application_supporting_platform;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.system.domain.TbOrganize;
import com.grainoil.system.service.ITbOrganizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 组织信息管理
 */
@RestController
@RequestMapping("organize")
@Api(tags = "组织管理")
public class TbOrganizeController extends BaseController {

    @Autowired
    ITbOrganizeService tbOrganizeService;

    /**
     * 根据条件分页查询组织信息列表
     *
     * @param organizeName 组织名称
     * @param organizeType 组织类型
     * @param organizeId 组织id
     * @return 组织信息集合
     */
    @ApiOperation(value = "获取组织列表", notes = "根据条件分页查询组织列表信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "organizeName", value = "组织名称"), @ApiImplicitParam(name = "organizeType", value = "组织类型"), @ApiImplicitParam(name = "organizeId", value = "组织id", required = true)})
    @GetMapping("list")
    public R list(String organizeName, String organizeType, Long organizeId) {
        startPage();
        return result(tbOrganizeService.list(organizeName, organizeType, organizeId));
    }

    /**
     * 添加组织信息
     *
     * @param organize 组织信息
     * @return ok/error
     */
    @ApiOperation(value = "添加组织信息", notes = "添加组织信息")
    @PostMapping("insert")
    public R insert(@ApiIgnore TbOrganize organize, Long organizeId) {
        organize.setCreateId(getCurrentUserId());
        organize.setUpdateId(getCurrentUserId());
        organize.setCreateBy(getLoginName());
        organize.setUpdateBy(getLoginName());
        return tbOrganizeService.insert(organize, organizeId);
    }

    /**
     * 获取组织管理树
     *
     * @param organizeId 树的根节点id
     * @return 组织管理树结构
     */
    @ApiOperation(value = "获取组织管理树", notes = "获取组织管理树")
    @ApiImplicitParams({@ApiImplicitParam(name = "organizeId", value = "当前用户所属的组织id", required = true)})
    @GetMapping("getTree")
    public R getTree(Long organizeId) {
        return R.data(tbOrganizeService.getTree(organizeId));
    }

    /**
     * 根据id获取组织信息
     *
     * @param organizeId 组织id
     * @return 组织信息
     */
    @GetMapping("get/{organizeId}")
    @ApiOperation(value = "根据id获取组织信息", notes = "根据id获取组织信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "organizeId", value = "组织id", required = true)})
    public R get(@PathVariable("organizeId") Long organizeId) {
        return tbOrganizeService.get(organizeId);
    }

    /**
     * 修改组织信息
     *
     * @param organize 组织信息
     * @return ok/error
     */
    @PostMapping("update")
    @ApiOperation(value = "修改组织信息", notes = "修改组织信息")
    public R update(TbOrganize organize) {
        organize.setUpdateBy(getLoginName());
        organize.setUpdateId(getCurrentUserId());
        return tbOrganizeService.update(organize);
    }

    /**
     * 获取所有的企业的下拉框
     *
     * @return 所有的企业的下拉框
     */
    @ApiOperation("获取所有的企业的下拉框")
    @GetMapping("getSelect")
    public R getSelect() {
        return tbOrganizeService.getSelect();
    }

    /**
     * 获取区粮管中心组织的下拉框
     *
     * @return 所有的企业的下拉框
     */
    @ApiOperation("获取区粮管中心组织的下拉框")
    @GetMapping("getCenter")
    public R getCenter() {
        return tbOrganizeService.getCenter();
    }
}
