package com.grainoil.system.domain.vo.variety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:59
 */
@ApiModel(description = "二级粮油品种", value = "VarietyChildren")
@Data
public class VarietyChildren implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "varietyName", value = "粮油品种名称", required = true)
    @NotBlank
    private String varietyName;

    @ApiModelProperty(name = "varietyShortname", value = "拼音简称", required = true)
    @NotBlank
    private String varietyShortname;

    @ApiModelProperty(name = "percent", value = "最低库存要求(%)", required = true)
    @NotNull
    private Double percent;

    @ApiModelProperty(name = "rotationPercent", value = "轮换时最高库存要求(%)", required = true)
    @NotNull
    private Double rotationPercent;

    @ApiModelProperty(name = "months", value = "核定承储周期(月)", required = true)
    @NotNull
    private Long months;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
