package com.grainoil.system.domain.vo.rotate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/27 10:48
 */
@Data
@ApiModel("年度轮换列表查询条件")
public class AnnualPlanDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "companyId", value = "承储企业id")
    private Long companyId;

    @ApiModelProperty(name = "region", value = "粮库所在区(数字字典)")
    private String region;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "varietyId", value = "粮油品种id")
    private Long varietyId;

    @ApiModelProperty(name = "state", value = "计划状态")
    private String state;

}
