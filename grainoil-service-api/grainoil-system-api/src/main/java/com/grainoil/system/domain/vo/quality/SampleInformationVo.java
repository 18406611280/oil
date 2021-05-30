package com.grainoil.system.domain.vo.quality;

import com.grainoil.system.domain.vo.GrainDepVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/14 11:01
 */
@Data
@ApiModel(description = "申请表基础信息")
public class SampleInformationVo {

    @ApiModelProperty(value="存储企业id",name="companyId")
    private Long companyId;

    @ApiModelProperty(value="存储企业名",name="companyName")
    private String companyName;

    @ApiModelProperty(value="质检机构id",name="qualityCompanyId")
    private Long qualityCompanyId;

    @ApiModelProperty(value="质检机构",name="qualityCompanyName")
    private String qualityCompanyName;

    @ApiModelProperty(value="粮库",name="grainVoList")
    private List<GrainDepVo> grainVoList;
}
