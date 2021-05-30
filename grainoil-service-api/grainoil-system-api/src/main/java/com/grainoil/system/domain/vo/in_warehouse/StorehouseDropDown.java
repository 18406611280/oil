package com.grainoil.system.domain.vo.in_warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "StorehouseDropDown", description = "仓房信息")
public class StorehouseDropDown implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "仓房id")
    private Long id;

    @ApiModelProperty(name = "name", value = "仓房名称")
    private String name;
}
