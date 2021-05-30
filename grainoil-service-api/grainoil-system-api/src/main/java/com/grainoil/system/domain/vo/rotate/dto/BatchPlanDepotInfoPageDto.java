package com.grainoil.system.domain.vo.rotate.dto;

import com.grainoil.common.core.page.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: yyl
 */
@Data
@ApiModel(description = "添加轮换库存清单列表分页")
public class BatchPlanDepotInfoPageDto extends PageQuery {

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮换申请单Id")
    private Long batchPlanInfoId;

    /**
     * 轮出粮库id
     */
    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出粮库")
    private String grainDepotName;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出仓房")
    private String storehouseName;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出堆位id")
    private Long heapId;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出堆位名")
    private String heapName;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出子堆id")
    private Long childHeapId;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出子堆编号")
    private String childHeapCode;

    @ApiModelProperty(name = "batchPlanInfoId",value = "轮出粮食品种")
    private String foodstuffTpye;

    @ApiModelProperty(name = "batchPlanInfoId",value = "入库时间（报批粮）")
    private String moveInDate;

    @ApiModelProperty(name = "batchPlanInfoId",value = "库存数量")
    private String stock;

}
