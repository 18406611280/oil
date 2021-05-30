package com.grainoil.system.domain.vo.rotate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "终止/变更申请表")
public class BatchPlan implements Serializable {

    @ApiModelProperty(name = "id",value = "轮换计划id")
    private Long id;

    /**
     * 轮换编号
     */
    @ApiModelProperty(name = "batchCode",value = "轮换编号")
    private String batchCode;

    @ApiModelProperty(name = "type",value ="品种")
    private String type;

    @ApiModelProperty(name = "stockNum",value ="数量")
    private Double stockNum;

    @ApiModelProperty(name = "grainDepotName",value ="粮库")
    private String grainDepotName;

    @ApiModelProperty(name = "stockTime",value ="轮换时间")
    private String stockTime;

    @ApiModelProperty(name = "stockTime",value ="累计轮出数量")
    private Double totalOutNum;

    @ApiModelProperty(name = "totalInNum",value ="累计轮入数量")
    private Double totalInNum;

    @ApiModelProperty(name = "remark",value ="备注")
    private String remark;

    @ApiModelProperty(name = "stockTime",value ="轮换后计划变化后情况")
    private BatchPlan batchPlan;

    public BatchPlan() {
    }

    public BatchPlan(String batchCode, String type, Double stockNum,
                     String grainDepotName, String stockTime,
                     Double totalOutNum, Double totalInNum, String remark) {
        this.batchCode = batchCode;
        this.type = type;
        this.stockNum = stockNum;
        this.grainDepotName = grainDepotName;
        this.stockTime = stockTime;
        this.totalOutNum = totalOutNum;
        this.totalInNum = totalInNum;
        this.remark = remark;
    }
}
