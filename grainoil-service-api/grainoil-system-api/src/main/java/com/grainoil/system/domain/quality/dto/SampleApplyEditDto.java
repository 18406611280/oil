package com.grainoil.system.domain.quality.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/19 11:53
 */
@Data
@ApiModel(description = "修改")
public class SampleApplyEditDto {

    @ApiModelProperty(value = "申请id")
    private Long id;

    @ApiModelProperty(value="样品信息",name="sampleDtoList")
    private List<SampleDto> sampleDtoList;

    @ApiModelProperty(value="备注",name="remark")
    private String remark;
}
