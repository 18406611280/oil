package com.grainoil.system.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 14:12
 */
@Data
@ApiModel
public class BiddingDeliverySaveDto {

    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    /**
     * 承储合同id
     */
    @ApiModelProperty(name = "storageContractId",value = "承储合同id")
    private Long storageContractId;

    /**
     * 批文编号
     */
    @ApiModelProperty(name = "contractCode",value = "批文编号")
    private String contractCode;

    /**
     * 批文名称
     */
    @ApiModelProperty(name = "contractName",value = "批文名称")
    private String contractName;

    /**
     * 批文附件
     */
    @ApiModelProperty(name = "fileId",value = "批文附件id")
    private Long fileId;

    /**
     * （合计）存储数量
     */
    @ApiModelProperty(name = "quantity",value = "出库数量")
    private Double quantity;

    /**
     * 出库开始时间
     */
    @ApiModelProperty(name = "beginDate",value = "出库开始时间")
    private Date beginDate;

    /**
     * 出库结束时间
     */
    @ApiModelProperty(name = "endDate",value = "出库结束时间")
    private Date endDate;
}
