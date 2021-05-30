package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/21 16:31
 */
@Data
@ApiModel
public class SampleQualityPageVo {

    @ApiModelProperty(name = "applyId",value = "申请id")
    private Long applyId;

    @ApiModelProperty(name = "sampleId",value = "样品id")
    private Long sampleId;

    @ApiModelProperty(name = "organizeName",value = "存储企业")
    private String organizeName;

    @ApiModelProperty(value="粮库",name="grainDepotName")
    private String grainDepotName;

    @ApiModelProperty(value="仓房",name="storehouseName")
    private String storehouseName;

    @ApiModelProperty(value="堆位名",name="heapName")
    private String heapName;

    @ApiModelProperty(value="粮食品种",name="variety")
    private String variety;

    @ApiModelProperty(value="数量",name="quantity")
    private Double quantity;

    @ApiModelProperty(name = "warehouseStartDate",value = "入库开始时间")
    private Date warehouseStartDate;

    @ApiModelProperty(name = "warehouseEndDate",value = "入库结束时间")
    private Date warehouseEndDate;

    @ApiModelProperty(name = "warehouseDate",value = "入库时间")
    private String warehouseDate;

    @ApiModelProperty(name = "batchCode",value = "轮换批次号")
    private String batchCode;

    @ApiModelProperty(name = "actualSamplingDate",value = "实际扦样日期")
    private Date actualSamplingDate;

    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;

}
