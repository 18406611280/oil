package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 修改仓房时的返回页面显示信息
 */
@Data
@ApiModel(value = "StorehouseGet", description = "根据id获取仓房信息")
public class StorehouseGet implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseCode", value = "仓房编码")
    private String storehouseCode;

    @ApiModelProperty(name = "storehouseType", value = "仓房类型(数字字典)")
    private String storehouseType;

    @ApiModelProperty(name = "storehouseCapacity", value = "仓房设计容量")
    private Double storehouseCapacity;

    @ApiModelProperty(name = "storehouseArea", value = "仓房面积")
    private Double storehouseArea;

    @ApiModelProperty(name = "storehouseYear", value = "建设年份")
    private Long storehouseYear;

    @ApiModelProperty(name = "organizeVoList", value = "使用企业集合")
    List<OrganizeVo> organizeVoList;

}
