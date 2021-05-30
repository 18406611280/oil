package com.grainoil.system.domain.vo.rotate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 申请日常轮换计划Vo
 * @author yyl
 * @date
 */
@Data
@ApiModel(description = "日常轮换申请时-> 视图实体类")
public class BatchPlanVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "annualPlanId", value = "年度轮换id")
    private Long annualPlanId;

    @ApiModelProperty(name = "annualPlan", value = "年度轮换名称")
    private AnnualPlan annualPlan;

    @ApiModelProperty(name = "relocationId", value = "移库批文id")
    private Long relocationId;

    @ApiModelProperty(name = "annualPlanForBatchPlanList", value = "年度计划列表")
    private List<AnnualPlanForBatchPlan> annualPlanForBatchPlanList;
}
