package com.grainoil.system.domain.vo.rotate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "日常轮换计划申请 -> 列表试图")
public class AnnualPlanForBatchPlan implements Serializable {

    @ApiModelProperty(name = "grainOilType", value = "粮油品种名称")
    private String grainOilType;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepot", value = "粮库")
    private String grainDepot;

    @ApiModelProperty(name = "annualPlanNum", value = "年度计划轮换数量")
    private Integer annualPlanNum;

    @ApiModelProperty(name = "storeTask", value = "已完成年度计划轮换数量")
    private Integer completeNum;

    @ApiModelProperty(name = "storeTask", value = "储备任务")
    private Integer storeTask;

    @ApiModelProperty(name = "currentStore", value = "当前库存数量")
    private Integer currentStore;

    @ApiModelProperty(name = "storeRate", value = "实时库存比例")
    private String storeRate;

    @ApiModelProperty(name = "uncompletedPlan", value = "未完成计划")
    private String uncompletedPlan;
}
