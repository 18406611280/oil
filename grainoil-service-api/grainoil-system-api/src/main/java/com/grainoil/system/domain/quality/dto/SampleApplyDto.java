package com.grainoil.system.domain.quality.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/17 9:57
 */
@Data
@ApiModel(description = "申请表单")
public class SampleApplyDto{

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    @NotBlank(message = "粮库不能为空")
    private Long grainDepotId;

    @ApiModelProperty(value="样品信息",name="sampleDtoList")
    private List<SampleDto> sampleDtoList;

    @ApiModelProperty(value="备注",name="remark")
    private String remark;

}
