package com.grainoil.system.domain.vo.variety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@Data
@ApiModel(value = "VarietyListVo", description = "粮油品种列表")
public class VarietyListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "firstId", value = "一级粮油品种id")
    private Long firstId;

    @ApiModelProperty(name = "firstName", value = "一级粮油品种名称")
    private String firstName;

    @ApiModelProperty(name = "secondId", value = "二级粮油品种id")
    private Long secondId;

    @ApiModelProperty(name = "secondName", value = "二级粮油品种名称")
    private String secondName;

    @ApiModelProperty(name = "varietyShortname", value = "拼音简称")
    private String varietyShortname;

    @ApiModelProperty(name = "percent", value = "最低库存要求(%)")
    private Double percent;

    @ApiModelProperty(name = "rotationPercent", value = "轮换时最高库存要求(%)")
    private Double rotationPercent;

    @ApiModelProperty(name = "months", value = "核定承储周期(月)")
    private Long months;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

}
