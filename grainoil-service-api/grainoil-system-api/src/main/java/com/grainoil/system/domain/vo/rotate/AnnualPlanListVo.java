package com.grainoil.system.domain.vo.rotate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/27 14:18
 */
@Data
@ApiModel("年度计划列表")
public class AnnualPlanListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "年度轮换计划id")
    private Long id;

    @ApiModelProperty(name = "organizeName", value = "承储企业")
    private String organizeName;

    @ApiModelProperty(name = "particularYear", value = "年份")
    private String particularYear;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "variety", value = "粮油品种")
    private String variety;

    @ApiModelProperty(name = "quantityStorage", value = "承储数量")
    private Double quantityStorage;

    @ApiModelProperty(name = "rotationQuantity", value = "轮换数量")
    private Double rotationQuantity;

    @ApiModelProperty(name = "delayedStorage", value = "延缓轮换数量")
    private Double delayedStorage;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "state", value = "状态")
    private String state;

}
