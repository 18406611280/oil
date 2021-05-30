package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/17 1:57
 */
@ApiModel(value = "StorehouseQuery", description = "仓房列表查询条件")
@Data
public class StorehouseQuery implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotId", value = "所属粮库id", required = true)
    private Long grainDepotId;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "belongId", value = "使用企业id")
    private Long belongId;


}
