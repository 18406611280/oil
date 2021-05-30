package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/17 18:53
 */
@Data
@ApiModel(description = "质检申请分页")
public class SampleQualityApplyPageVo {

    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    /**
     * 申请编号
     */
    @ApiModelProperty(name = "applyCode",value = "申请编号")
    private String applyCode;

    @ApiModelProperty(name = "sampleNumber",value = "样品数量")
    private Integer sampleNumber;

    @ApiModelProperty(name = "quantity",value = "代表数量")
    private Double quantity;

    @ApiModelProperty(name = "warehouseDate",value = "入库时间")
    private String warehouseDate;

    @ApiModelProperty(name = "batchCode",value = "轮换编号")
    private String batchCode;

    /**
     * 申请日期
     */
    @ApiModelProperty(name = "applyDate",value = "申请日期")
    private Date applyDate;

    /**
     * 检验机构id
     */
    @ApiModelProperty(name = "qualityOrg",value = "检验机构id")
    private Long qualityOrg;

    /**
     * 检验机构
     */
    @ApiModelProperty(name = "qualityOrgName",value = "检验机构名称")
    private String qualityOrgName;

    /**
     * 状态
     */
    @ApiModelProperty(name = "state",value = "状态")
    private String state;

    /**
     * 预约日期
     */
    @ApiModelProperty(name = "appointmentDate",value = "预约日期")
    private Date appointmentDate;

    /**
     * 实际扦样日期
     */
    @ApiModelProperty(name = "actualSamplingDate",value = "实际扦样日期")
    private Date actualSamplingDate;

    /**
     * 备注
     */
    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;

}
