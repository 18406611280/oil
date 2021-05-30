package com.grainoil.system.domain.vo.variety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @Description 粮油品种添加修改时实体类
 * @date create in 21/5/14 10:29
 */
@Data
@ApiModel(value = "VarietyVo", description = "粮油品种新增和编辑")
public class VarietyVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "varietyId", value = "id")
    private Long varietyId;

    @ApiModelProperty(name = "varietyName", value = "粮油品种名称", required = true)
    @NotBlank(message = "粮油品种名称为必填项")
    private String varietyName;

    @NotBlank(message = "拼音简称为必填项")
    @ApiModelProperty(name = "varietyShortname", value = "拼音简称", required = true)
    private String varietyShortname;

    @NotNull(message = "最低库存要求(%)为必填项")
    @ApiModelProperty(name = "percent", value = "最低库存要求(%)", required = true)
    @Max(value = 100, message = "最低库存要求(%)最大值为100")
    @Min(value = 0, message = "最低库存要求(%)最小值为0")
    private Double percent;

    @NotNull(message = "轮换时最高库存要求(%)为必填项")
    @Max(value = 100, message = "轮换时最高库存要求(%)最大值为100")
    @Min(value = 0, message = "轮换时最高库存要求(%)最小值为0")
    @ApiModelProperty(name = "rotationPercent", value = "轮换时最高库存要求(%)", required = true)
    private Double rotationPercent;

    @NotNull(message = "核定承储周期(月)为必填项")
    @ApiModelProperty(name = "months", value = "核定承储周期(月)", required = true)
    @Min(value = 1, message = "核定承储周期(月)最小值为1")
    private Long months;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @NotNull(message = "二级粮油品种列表可以为空数组但是不能为null")
    @ApiModelProperty(name = "list", value = "二级粮油品种列表", required = true)
    private List<VarietyChildren> list;

    @ApiModelProperty(name = "disabled", value = "修改时用到,true表示修改一二级粮油品种信息,false表示只修改二级粮油品种信息")
    private boolean disabled;

}
