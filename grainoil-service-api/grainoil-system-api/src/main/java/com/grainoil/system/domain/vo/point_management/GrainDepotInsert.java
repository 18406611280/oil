package com.grainoil.system.domain.vo.point_management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@Data
@ApiModel(value = "GrainDepotInsert", description = "粮库新增")
public class GrainDepotInsert implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称", required = true)
    @NotBlank(message = "粮库名称为必填项")
    private String grainDepotName;

    @ApiModelProperty(name = "grainDepotCode", value = "粮库编码", required = true)
    @NotBlank(message = "粮库编码为必填项")
    private String grainDepotCode;

    @ApiModelProperty(name = "grainDepotRegion", value = "所在行政区(数字字典)", required = true)
    @NotBlank(message = "所在行政区为必填项")
    private String grainDepotRegion;

    @ApiModelProperty(name = "grainDepotLongitude", value = "经度")
    private Double grainDepotLongitude;

    @ApiModelProperty(name = "grainDepotLatitude", value = "纬度")
    private Double grainDepotLatitude;

    @ApiModelProperty(name = "grainDepotCapacity", value = "设计容量(吨)")
    private Double grainDepotCapacity;

    @ApiModelProperty(name = "grainDepotPosition", value = "地址")
    private String grainDepotPosition;

    @ApiModelProperty(name = "belongId", value = "公司id", required = true)
    @NotNull(message = "公司id为必填项")
    private Long belongId;

    @JsonIgnore
    private String belongName;

    @ApiModelProperty(name = "centerId", value = "上级管理组织id", required = true)
    @NotNull(message = "上级管理组织id为必填项")
    private Long centerId;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

}
