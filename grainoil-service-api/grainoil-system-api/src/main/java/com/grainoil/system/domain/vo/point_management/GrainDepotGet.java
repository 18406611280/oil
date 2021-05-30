package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@Data
@ApiModel(value = "GrainDepotGet", description = "根据id获取的粮库信息粮库")
public class GrainDepotGet implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "grainDepotCode", value = "粮库编码")
    private String grainDepotCode;

    @ApiModelProperty(name = "grainDepotRegion", value = "行政区")
    private String grainDepotRegion;

    @ApiModelProperty(name = "grainDepotLongitude", value = "经度")
    private Double grainDepotLongitude;

    @ApiModelProperty(name = "grainDepotLatitude", value = "纬度")
    private Double grainDepotLatitude;

    @ApiModelProperty(name = "grainDepotCapacity", value = "设计容量(吨)")
    private Double grainDepotCapacity;

    @ApiModelProperty(name = "grainDepotPosition", value = "地址")
    private String grainDepotPosition;

    @ApiModelProperty(name = "belongId", value = "公司id")
    private Long belongId;

    @ApiModelProperty(name = "belongName", value = "公司名称")
    private String belongName;

    @ApiModelProperty(name = "centerId", value = "上级管理组织id")
    private Long centerId;

    @ApiModelProperty(name = "centerName", value = "上级管理组织名称")
    private String centerName;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "organizeVoList", value = "粮库使用企业信息")
    private List<OrganizeVo> organizeVoList;

}
