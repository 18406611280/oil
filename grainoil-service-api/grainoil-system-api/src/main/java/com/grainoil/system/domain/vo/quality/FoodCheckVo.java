package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodCheckVo {

    /**
     * 项名称
     */
    @ApiModelProperty(value="项名称",name="varietyId")
    private String termName;

    /**
     * 申请类型(0不可修改)
     */
    @ApiModelProperty(value="申请类型",name="applyType")
    private String applyType;

    /**
     * 提示
     */
    @ApiModelProperty(value="提示",name="varietyId")
    private String standard;
}
