package com.grainoil.system.domain.quality;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TbQualityApplyDetailed {
    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    private Long inventoryId;

    /**
     * 扦样编号
     */
    @ApiModelProperty(name = "samplingCode",value = "扦样编号")
    private String samplingCode;

    /**
     * 质检申请id
     */
    @ApiModelProperty(name = "applyId",value = "质检申请id")
    private Long applyId;

    /**
     * 粮食品种_id
     */
    @ApiModelProperty(name = "varietyId",value = "粮食品种_id")
    private Long varietyId;

    /**
     * 样品编号
     */
    @ApiModelProperty(name = "sampleCode",value = "样品编号")
    private String sampleCode;

    /**
     * 粮食品种
     */
    @ApiModelProperty(name = "variety",value = "粮食品种")
    private String variety;

    /**
     * 样品名称
     */
    @ApiModelProperty(name = "sampleName",value = "样品名称")
    private String sampleName;

    /**
     * 仓房id
     */
    @ApiModelProperty(name = "storehouseId",value = "仓房id")
    private Long storehouseId;

    /**
     * 仓房
     */
    @ApiModelProperty(name = "storehouseName",value = "仓房")
    private String storehouseName;

    /**
     * 堆位id
     */
    @ApiModelProperty(name = "heapId",value = "堆位id")
    private Long heapId;

    /**
     * 堆位
     */
    @ApiModelProperty(name = "heapName",value = "堆位")
    private String heapName;

    /**
     * 代表数量
     */
    @ApiModelProperty(name = "quantity",value = "代表数量")
    private Double quantity;

    /**
     * 产地
     */
    @ApiModelProperty(name = "producingArea",value = "产地")
    private String producingArea;

    /**
     * 生产年份
     */
    @ApiModelProperty(name = "particularYear",value = "收货年度")
    private Date particularYear;

    /**
     * 入库开始时间
     */
    @ApiModelProperty(name = "warehouseStartDate",value = "入库开始时间")
    private Date warehouseStartDate;

    /**
     * 入库结束时间
     */
    @ApiModelProperty(name = "warehouseEndDate",value = "入库结束时间")
    private Date warehouseEndDate;

    /**
     * 轮换批次号
     */
    @ApiModelProperty(name = "batchCode",value = "轮换批次号")
    private String batchCode;

    /**
     * 粮食等级
     */
    @ApiModelProperty(name = "grade",value = "等级")
    private String grade;

    /**
     * 包装/散装
     */
    @ApiModelProperty(name = "packingType",value = "包装/散装")
    private String packingType;

    /**
     * 备注
     */
    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;

    /**
     * 轮换计划或者存储合同id
     */
    @ApiModelProperty(name = "contractId",value = "轮换计划或者存储合同id")
    private Long contractId;

    /**
     * （出）入仓单Id
     */
    @ApiModelProperty(name = "receiptId",value = "（出）入仓单Id")
    private Long receiptId;

    /**
     * 扦样时间
     */
    @ApiModelProperty(name = "samplingTime",value = "扦样时间")
    private Date samplingTime;

    /**
     * 质检状态
     */
    @ApiModelProperty(name = "state",value = "质检状态")
    private String state;

    /**
     * 报告附件
     */
    @ApiModelProperty(name = "enclosure",value = "报告附件")
    private String enclosure;

    /**
     * 质检报告名称
     */
    @ApiModelProperty(name = "reportName",value = "质检报告名称")
    private String reportName;

    /**
     * 质检结果
     */
    @ApiModelProperty(name = "checkResult",value = "质检结果")
    private String checkResult;

    /**
     * 质检报告编号
     */
    @ApiModelProperty(name = "reportCode",value = "质检报告编号")
    private String reportCode;

    /**
     * 报告签发时间
     */
    @ApiModelProperty(name = "reportTime",value = "报告签发时间")
    private Date reportTime;

    /**
     * 检验周期(签发时间-扦样时间)
     */
    @ApiModelProperty(name = "examineCycle",value = "检验周期(签发时间-扦样时间)")
    private Long examineCycle;

    /**
     * 是否超期(检验周期>15天)
     */
    @ApiModelProperty(name = "isOverdue",value = "是否超期(检验周期>15天)")
    private String isOverdue;
}