package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/17 2:03
 */
@Data
@ApiModel(value = "StorehouseListVo", description = "仓房列表")
public class StorehouseListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName", value = "仓房名称")
    private String storehouseName;

    @ApiModelProperty(name = "storehouseState", value = "仓房状态")
    private String storehouseState;

    @ApiModelProperty(name = "storehouseArea", value = "仓房面积")
    private Double storehouseArea;

    @ApiModelProperty(name = "storehouseCapacity", value = "仓房设计容量")
    private Double storehouseCapacity;

    @ApiModelProperty(name = "useName", value = "使用企业")
    private String useName;

    @ApiModelProperty(name = "type", value = "我的还是代储")
    private String type;
}
