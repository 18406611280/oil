package com.grainoil.system.domain.vo.point_management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@Data
@ApiModel(value = "GrainDepotUpdate", description = "粮库修改")
public class GrainDepotUpdate implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id", required = true)
    @NotNull(message = "粮库id不能为空")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称", required = true)
    @NotBlank(message = "粮库名称不能为空")
    private String grainDepotName;

    @ApiModelProperty(name = "grainDepotCode", value = "粮库编码", required = true)
    @NotBlank(message = "粮库编码不能为空")
    private String grainDepotCode;

    @ApiModelProperty(name = "grainDepotRegion", value = "行政区", required = true)
    @NotBlank(message = "行政区不能为空")
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

    /**
     * 公司名称
     */
    @JsonIgnore
    private String belongName;

    @ApiModelProperty(name = "centerId", value = "上级管理组织id", required = true)
    @NotNull(message = "上级管理组织id为必填项")
    private Long centerId;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "personId", value = "所选粮库负责人id(粮库负责人有下拉框时才用到)")
    private List<Long> personId;

}
