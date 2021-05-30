package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 修改仓房时的返回页面显示信息
 */
@Data
@ApiModel(value = "StorehouseVo", description = "仓房添加与修改")
public class StorehouseVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "storehouseId", value = "仓房id(添加仓房时不需要)")
    private Long storehouseId;

    @ApiModelProperty(name = "grainDepotId", value = "所属粮库id", required = true)
    @NotNull(message = "所属粮库id不能为空")
    private Long grainDepotId;

    @ApiModelProperty(name = "storehouseCode", value = "仓房编码", required = true)
    @NotBlank(message = "仓房编码不能为空")
    private String storehouseCode;

    @ApiModelProperty(name = "storehouseType", value = "仓房类型(数字字典)", required = true)
    @NotBlank(message = "仓房类型不能为空")
    private String storehouseType;

    @ApiModelProperty(name = "storehouseCapacity", value = "仓房设计容量", required = true)
    @NotNull(message = "设计容量不能为空")
    private Double storehouseCapacity;

    @ApiModelProperty(name = "storehouseArea", value = "仓房面积")
    private Double storehouseArea;

    @ApiModelProperty(name = "storehouseYear", value = "建设年份")
    private Long storehouseYear;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "organizeIds", value = "使用企业id集合(添加仓房时不需要)")
    private List<Long> organizeIds;

    @ApiModelProperty(name = "personIds", value = "仓房管理员id集合(添加仓房时不需要")
    private List<Long> personIds;

}
