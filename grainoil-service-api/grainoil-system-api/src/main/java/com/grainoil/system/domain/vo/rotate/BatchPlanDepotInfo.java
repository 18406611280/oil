package com.grainoil.system.domain.vo.rotate;

import com.grainoil.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(description = "日常轮换库存清单-修改")
public class BatchPlanDepotInfo implements Serializable {
    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id",value = "日常轮换库存清单id")
    private Long id;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮换申请单id")
    private Long batchPlanInfoId;

    @ApiModelProperty(name = "grainDepotId",value = "轮出粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName",value = "轮出粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId",value = "轮出仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName",value = "轮出仓房")
    private String storehouseName;

    @ApiModelProperty(name = "heapId",value = "轮出堆位id")
    private Long heapId;

    @ApiModelProperty(name = "heapName",value = "轮出堆位名")
    private String heapName;

    @ApiModelProperty(name = "childHeapId",value = "轮出子堆id")
    private Long childHeapId;

    @ApiModelProperty(name = "childHeapCode",value = "轮出子堆编号")
    private String childHeapCode;

    @ApiModelProperty(name = "producingArea",value = "产地")
    private String producingArea;

    @ApiModelProperty(name = "moveInDate",value = "入库时间")
    private String moveInDate;

    @ApiModelProperty(name = "depositType",value = "存放方式")
    private String depositType;

    @ApiModelProperty(name = "stock",value = "库存数量")
    private Double stock;

    @ApiModelProperty(name = "outStock",value = "轮换吨数")
    private Double outStock;

    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;
}
