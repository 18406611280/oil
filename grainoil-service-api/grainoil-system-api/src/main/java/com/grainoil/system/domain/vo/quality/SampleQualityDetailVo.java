package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/24 16:12
 */
@Data
@ApiModel
public class SampleQualityDetailVo {

    @ApiModelProperty(name = "sampleCode",value = "样品编号")
    private String sampleCode;

    @ApiModelProperty(name = "sampleCode",value = "品种名称")
    private String variety;

    @ApiModelProperty(name = "grainDepotName",value = "粮库")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseName",value = "仓房")
    private String storehouseName;

    @ApiModelProperty(name = "heapName",value = "堆位名")
    private String heapName;

//    @ApiModelProperty(name = "childHeapCode",value = "子堆编号")
//    private String childHeapCode;

    @ApiModelProperty(name = "quantity",value = "数量")
    private Double quantity;

    @ApiModelProperty(name = "warehouseDate",value = "入库时间")
    private String warehouseDate;

    @ApiModelProperty(name = "batchCode",value = "轮换批次号")
    private String batchCode;

    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;

    @ApiModelProperty(name = "foodCheckItemVos",value = "质检项")
    private List<FoodCheckItemVo> foodCheckItemVos;

    @ApiModelProperty(name = "checkResult",value = "质检结果")
    private String checkResult;
}
