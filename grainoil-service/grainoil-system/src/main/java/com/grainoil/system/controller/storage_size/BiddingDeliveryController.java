package com.grainoil.system.controller.storage_size;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.dto.BiddingDeliveryPageDto;
import com.grainoil.system.domain.dto.BiddingDeliverySaveDto;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryDetailVo;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryPageVo;
import com.grainoil.system.service.BiddingDeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 13:48
 */
@RestController
@RequestMapping("/biddingDelivery")
@Api(tags = "竞价出库管理")
public class BiddingDeliveryController extends BaseController {

    @Autowired
    private BiddingDeliveryService biddingDeliveryService;

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/add")
    public ResponseResult addDailyQuality(@RequestBody @Valid BiddingDeliverySaveDto saveDto){
        CurrentUser currentUser = getCurrentUser();
        biddingDeliveryService.save(saveDto);
        return ResponseResult.success();
    }

    /**
     * 获取批文存储合同信息
     */
    @ApiOperation("获取批文存储合同信息")
    @GetMapping("/getContractMessage/{ContractId}")
    @ApiImplicitParam(name = "ContractId", value = "存储合同id",readOnly = true)
    public ResponseResult<BiddingDeliveryDetailVo> getStorageMessage(@PathVariable("ContractId") Long contractId){
        BiddingDeliveryDetailVo contractMessageVo = biddingDeliveryService.getStorageMessage(contractId);
        return ResponseResult.success(contractMessageVo);
    }

    /**
     * 分页
     */
    @ApiOperation("分页")
    @PostMapping("/page")
    public ResponseResult<PageView<BiddingDeliveryPageVo>> page(@RequestBody BiddingDeliveryPageDto biddingDeliveryPageDto){
        PageView<BiddingDeliveryPageVo> pageVo = biddingDeliveryService.page(biddingDeliveryPageDto);
        return ResponseResult.success(pageVo);
    }

    /**
     * 获取批文详情
     */
    @ApiOperation("获取批文详情")
    @GetMapping("/getBiddingDelivery/{id}")
    @ApiImplicitParam(name = "id", value = "批文id",readOnly = true)
    public ResponseResult<BiddingDeliveryDetailVo> getBiddingDelivery(@PathVariable("id") Long id){
        BiddingDeliveryDetailVo contractMessageVo = biddingDeliveryService.getBiddingDelivery(id);
        return ResponseResult.success(contractMessageVo);
    }



}
