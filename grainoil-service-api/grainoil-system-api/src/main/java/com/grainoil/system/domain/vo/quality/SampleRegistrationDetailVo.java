package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/20 15:19
 */
@Data
@ApiModel(description = "样品登记详情")
public class SampleRegistrationDetailVo {

    @ApiModelProperty(value="申请id",name="id")
    private Long id;

    @ApiModelProperty(value="存储企业名",name="companyName")
    private String OrganizeName;

    @ApiModelProperty(value="扦样人",name="samplers")
    private String samplers;

    @ApiModelProperty(value="扦样日期",name="actualSamplingDate")
    private Date actualSamplingDate;

    @ApiModelProperty(value="样品列表",name="sampleVos")
    private List<RegisterSampleVo> sampleVos;



}
