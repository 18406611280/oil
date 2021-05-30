package com.grainoil.system.domain.quality.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 14:20
 */
@Data
public class RegisterSampleDto {

    @ApiModelProperty(value = "样品id")
    private Long id;

    @ApiModelProperty(value = "样品编号")
    private String sampleCode;
}
