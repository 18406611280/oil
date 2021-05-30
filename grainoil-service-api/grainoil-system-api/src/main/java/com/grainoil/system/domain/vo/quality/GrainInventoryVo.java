package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/24 10:05
 */
@Data
public class GrainInventoryVo {

    @ApiModelProperty(name = "inventoryId",value = "粮库信息id")
    private Long inventoryId;

    @ApiModelProperty(name = "grainDepotId",value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName",value = "粮库")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId",value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName",value = "仓房")
    private String storehouseName;

    @ApiModelProperty(name = "heapId",value = "堆位id")
    private Long heapId;

    @ApiModelProperty(name = "heapName",value = "堆位名")
    private String heapName;

    @ApiModelProperty(name = "childHeapCode",value = "子堆编号")
    private String childHeapCode;

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

}
