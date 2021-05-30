package com.grainoil.system.domain.quality.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: chenminghong
 * @Date: 2021/5/17 11:08
 */
@ApiModel(description = "样品入参")
@Data
public class SampleDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "粮库信息id")
    private Long inventoryId;

    @ApiModelProperty(value = "样品名称")
    @NotBlank(message = "样品名称不能为空")
    private String sampleName;

    @ApiModelProperty(value = "质检结果")
    private String checkResult;
}
