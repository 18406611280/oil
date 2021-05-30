package com.grainoil.system.controller.common;

import com.grainoil.common.constant.Constants;
import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.redis.util.RedisUtils;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.domain.vo.common.SecondNode;
import com.grainoil.system.domain.vo.common.ThirdNode;
import com.grainoil.system.service.ITbGrainDepotService;
import com.grainoil.system.service.ITbOrganizeLqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 15:21
 */
@Api(value = "TbCommonController", tags = "公共接口")
@RestController
@RequestMapping("common")
public class TbCommonController extends BaseController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    ITbGrainDepotService grainDepotService;

    @Autowired
    ITbOrganizeLqService organizeLqService;

    /**
     * 选择粮权或切换粮权
     *
     * @param lqId 粮权id
     * @param token token信息
     * @return 结果
     */
    @ApiOperation("选择粮权或切换粮权")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "lqId", value = "粮权id", required = true),
        @ApiImplicitParam(name = "token", value = "token信息", required = true)
    })
    @GetMapping("setLq")
    public ResponseResult setLq(Long lqId, String token) {
        if (lqId == null || StringUtils.isBlank(token)) {
            return ResponseResult.error("参数错误");
        }
        redisUtils.set(Constants.CURRENT_LQ + token, lqId);
        return ResponseResult.success();
    }

    @ApiOperation("获取列表查询条件粮库下拉框")
    @GetMapping("getGrainDepotList")
    public ResponseResult<List<LeafNode>> getGrainDepotList() {
        return ResponseResult.success(grainDepotService.getGrainDepotList(getOrganizeId(), getOrganizeType()));
    }

    @ApiOperation("获取粮库-仓房联动下拉框")
    @GetMapping("getSecondNode")
    public ResponseResult<List<SecondNode>> getSecondNode() {
        return ResponseResult.success(grainDepotService.getSecondNode(getOrganizeId(), getOrganizeType()));
    }

    @ApiOperation("获取粮库-仓房-堆位联动下拉框")
    @GetMapping("getThirdNode")
    public ResponseResult<List<ThirdNode>> getThirdNode() {
        return ResponseResult.success(grainDepotService.getThirdNode(getOrganizeId(), getOrganizeType()));
    }

    @ApiOperation("获取承储企业下拉框")
    @GetMapping("getCompanyList")
    public ResponseResult<List<LeafNode>> getCompanyList() {
        return ResponseResult.success(organizeLqService.getCompanyList(getOrganizeId()));
    }

}
