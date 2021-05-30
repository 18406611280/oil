package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 14:53
 */
@Data
@ApiModel(description = "质检报告")
public class QualityReportPageVo {

    @ApiModelProperty(name = "applyId",value = "申请id")
    private Long applyId;

    @ApiModelProperty(name = "sampleId",value = "样品id")
    private Long sampleId;

    @ApiModelProperty(name = "applyCode",value = "申请编号")
    private String applyCode;

    @ApiModelProperty(name = "sampleCode",value = "样品编号")
    private String sampleCode;

    @ApiModelProperty(name = "organizeName",value = "申请企业")
    private String organizeName;

    @ApiModelProperty(value="报告编号",name="reportCode")
    private String reportCode;

    @ApiModelProperty(name = "batchCode",value = "轮换编号")
    private String batchCode;

    @ApiModelProperty(value="粮库",name="grainDepotName")
    private String grainDepotName;

    @ApiModelProperty(name = "samplingTime",value = "扦样时间")
    private Date samplingTime;

    @ApiModelProperty(value="扦样人",name="samplers")
    private String samplers;

    @ApiModelProperty(value="质检状态",name="state")
    private String state;

    @ApiModelProperty(name = "reportTime",value = "质检时间")
    private Date reportTime;

    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;


}
