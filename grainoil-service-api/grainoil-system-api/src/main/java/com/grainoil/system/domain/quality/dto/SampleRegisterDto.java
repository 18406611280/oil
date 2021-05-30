package com.grainoil.system.domain.quality.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 14:17
 */
@Data
@ApiModel
public class SampleRegisterDto {

    @ApiModelProperty(value="申请id",name="id")
    private Long id;

    @ApiModelProperty(value="扦样人",name="samplers")
    @NotBlank(message = "扦样人不能为空")
    private String samplers;

    @ApiModelProperty(value="扦样日期",name="actualSamplingDate")
    @NotBlank(message = "日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualSamplingDate;

    @ApiModelProperty(value="样品列表")
    private List<RegisterSampleDto> sampleDto;
}
