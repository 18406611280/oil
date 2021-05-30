package com.grainoil.system.domain.vo.storage_contract;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 15:28
 */
@Data
@ApiModel
public class BiddingDeliveryPageVo {

    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    @ApiModelProperty(name = "organizeName",value = "存储企业")
    private String organizeName;

    @ApiModelProperty(name = "quantity",value = "存储数量")
    private Double quantity;

    @ApiModelProperty(name = "currentQuantity",value = "当前库存数量")
    private Double currentQuantity;

    @ApiModelProperty(name = "deliveryQuantity",value = "已出库数量")
    private Double deliveryQuantity;

    @ApiModelProperty(name = "contractCode",value = "批文编号")
    private String contractCode;

    @ApiModelProperty(name = "storageContractCode",value = "存储合同编号")
    private String storageContractCode;

    @ApiModelProperty(name = "contractName",value = "批文名称")
    private String contractName;

    @ApiModelProperty(name = "contractState",value = "批文状态")
    private String contractState;

    @ApiModelProperty(name = "storageDate",value = "存储时间")
    private String storageDate;

    @ApiModelProperty(name = "deliveryDate",value = "出库时间")
    private String deliveryDate;
}
