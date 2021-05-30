package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 16:17
 */
@Data
@ApiModel(value = "GrainDepotListVo", description = "粮库列表")
public class GrainDepotListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "belongName", value = "所属企业名称")
    private String belongName;

    @ApiModelProperty(name = "grainDepotCapacity", value = "设计容量")
    private Double grainDepotCapacity;

    @ApiModelProperty(name = "grainDepotState", value = "粮库状态")
    private String grainDepotState;

    @ApiModelProperty(name = "useName", value = "使用企业")
    private String useName;

    @ApiModelProperty(name = "type", value = "我的还是代储")
    private String type;
}
