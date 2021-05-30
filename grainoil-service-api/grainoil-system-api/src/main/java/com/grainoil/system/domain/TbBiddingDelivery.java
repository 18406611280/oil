package com.grainoil.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TbBiddingDelivery {
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
    @ApiModelProperty(name = "fileId",value = "批文附件")
    private Long fileId;

    /**
     * 批文状态
     */
    @ApiModelProperty(name = "contractState",value = "批文状态")
    private String contractState;

    /**
     * 出库数量
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

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createBy",value = "创建人")
    private String createBy;

    /**
     * 创建id
     */
    @ApiModelProperty(name = "createId",value = "创建id")
    private Long createId;

    /**
     * 创建日期
     */
    @ApiModelProperty(name = "createTime",value = "创建日期")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateBy",value = "更新人")
    private String updateBy;

    /**
     * 更新人id
     */
    @ApiModelProperty(name = "updateId",value = "更新人id")
    private Long updateId;

    /**
     * 更新日期
     */
    @ApiModelProperty(name = "updateTime",value = "更新日期")
    private Date updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty(name = "delFlag",value = "是否删除")
    private String delFlag;
}