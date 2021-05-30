package com.grainoil.system.domain.vo.rotate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class AnnualPlan implements Serializable {
    @ApiModelProperty(name = "id",value = "日常轮换申请单id")
    private Long id;

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "annualPlan", value = "年度轮换名称")
    private String annualPlan;

}
