package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/18 18:38
 */
@Data
@ApiModel(description = "质检申请详情页面")
public class QualityApplyDetailVo {

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Long grainDepotId;

    @ApiModelProperty(value="粮库",name="grainDepot")
    private String grainDepotName;

    @ApiModelProperty(value="存储企业名",name="companyName")
    private String companyName;

    @ApiModelProperty(value="质检机构",name="qualityCompanyName")
    private String qualityCompanyName;

    @ApiModelProperty(value="样品信息",name="sampleDtoList")
    private List<SampleVo> sampleVoList;

    @ApiModelProperty(value="备注",name="remark")
    private String remark;

}
