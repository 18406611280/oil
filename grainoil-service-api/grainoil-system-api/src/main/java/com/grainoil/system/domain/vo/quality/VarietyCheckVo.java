package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="VarietyCheckVo",description="质检项")
public class VarietyCheckVo {

    /**
     * 一级品种id
     */
    @ApiModelProperty(value="一级品种id",name="firstId",required=true)
    private Long firstId;
    /**
     * 二级品种id
     */
    @ApiModelProperty(value="二级品种id",name="secondId",required=true)
    private Long secondId;
    /**
     * 一级品种
     */
    @ApiModelProperty(value="一级品种",name="firstName",required=true)
    private String firstName;

    /**
     * 二级品种
     */
    @ApiModelProperty(value="二级品种",name="secondName",required=true)
    private String secondName;

    /**
     * 项目数
     */
    @ApiModelProperty(value="项目数",name="itemNumber",required=true)
    private Integer itemNumber;
}
