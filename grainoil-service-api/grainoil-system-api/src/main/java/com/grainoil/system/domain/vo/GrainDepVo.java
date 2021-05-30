package com.grainoil.system.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/14 11:17
 */
@Data
@ApiModel("粮库信息")
public class GrainDepVo {

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Long grainDepotId;

    @ApiModelProperty(value="粮库名称",name="grainDepotName")
    private String grainDepotName;
}
