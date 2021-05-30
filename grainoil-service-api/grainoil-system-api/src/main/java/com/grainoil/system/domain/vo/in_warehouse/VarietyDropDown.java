package com.grainoil.system.domain.vo.in_warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "VarietyDropDown", description = "粮油品种信息")
public class VarietyDropDown implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "varietyId", value = "粮油品种id")
    private Long varietyId;

    @ApiModelProperty(name = "varietyName", value = "粮油品种名称")
    private String varietyName;
}
