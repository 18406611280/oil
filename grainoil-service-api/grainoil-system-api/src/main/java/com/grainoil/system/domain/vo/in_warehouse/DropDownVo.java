package com.grainoil.system.domain.vo.in_warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 入库管理添加时粮库-粮油品种/粮库-仓房之间的关系
 */
@Data
@ApiModel(value = "DropDownVo", description = "下拉列表关联")
public class DropDownVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "粮库id")
    private Long id;

    @ApiModelProperty(name = "name", value = "粮库名称")
    private String name;

    @ApiModelProperty(name = "varieties", value = "粮油品种列表")
    private List<VarietyDropDown> varieties;

    @ApiModelProperty(name = "storehouses", value = "仓房列表")
    private List<StorehouseDropDown> storehouses;
}
