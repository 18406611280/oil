package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/20 11:37
 */
@Data
@ApiModel(description = "样品登记分页")
public class SampleRegistrationPageVo {

    @ApiModelProperty(name = "申请id",value = "applyId")
    private Long applyId;

    @ApiModelProperty(name = "applyCode",value = "申请编号")
    private String applyCode;

    @ApiModelProperty(name = "sampleCode",value = "样品编号")
    private String sampleCode;

    @ApiModelProperty(name = "quantity",value = "代表数量")
    private Double quantity;

    @ApiModelProperty(value="粮库",name="grainDepotName")
    private String grainDepotName;

    @ApiModelProperty(value="仓房",name="storehouseName")
    private String storehouseName;

    @ApiModelProperty(value="堆位名",name="heapName")
    private String heapName;

    @ApiModelProperty(name = "batchCode",value = "轮换编号")
    private String batchCode;

    @ApiModelProperty(name = "producingArea",value = "产地")
    private String producingArea;

    @ApiModelProperty(value="生产年份",name="particularYear")
    private String particularYear;

    @ApiModelProperty(name = "samplingTime",value = "扦样时间")
    private Date samplingTime;

    @ApiModelProperty(value="扦样人",name="samplers")
    private String samplers;

    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;

    @ApiModelProperty(name = "organizeName",value = "存储企业")
    private String organizeName;


}
