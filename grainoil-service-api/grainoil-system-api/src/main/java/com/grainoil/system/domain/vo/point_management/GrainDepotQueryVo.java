package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 16:07
 */
@Data
@ApiModel(value = "GrainDepotQueryVo", description = "粮库查询条件")
public class GrainDepotQueryVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "belongId", value = "使用企业id")
    private Long belongId;

}
