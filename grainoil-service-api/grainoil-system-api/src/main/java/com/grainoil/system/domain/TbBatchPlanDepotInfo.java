package com.grainoil.system.domain;

import com.grainoil.common.annotation.Excel;
import com.grainoil.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class TbBatchPlanDepotInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 轮换申请单Id */
    @Excel(name = "轮换申请单Id")
    private Long batchPlanInfoId;

    /** 轮出粮库id */
    @Excel(name = "轮出粮库id")
    private Long grainDepotId;

    /** 轮出粮库 */
    @Excel(name = "轮出粮库")
    private String grainDepotName;

    /** 轮出仓房id */
    @Excel(name = "轮出仓房id")
    private Long storehouseId;

    /** 轮出仓房 */
    @Excel(name = "轮出仓房")
    private String storehouseName;

    /** 轮出堆位id */
    @Excel(name = "轮出堆位id")
    private Long heapId;

    /** 轮出子堆id */
    @Excel(name = "轮出子堆id")
    private Long childHeapId;

    /** 轮出子堆编号 */
    @Excel(name = "轮出子堆编号")
    private String childHeapCode;

    /** 轮出堆位名 */
    @Excel(name = "轮出堆位名")
    private String heapName;

    /** 轮出粮食品种 */
    @Excel(name = "轮出粮食品种")
    private String foodstuffTpye;

    /** 产地 */
    @Excel(name = "产地")
    private String producingArea;

    /** 入库时间（报批粮） */
    @Excel(name = "入库时间", readConverterExp = "报=批粮")
    private String moveInDate;

    /** 存放方式 */
    @Excel(name = "存放方式")
    private String depositType;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stock;

    /** 轮换数量 */
    @Excel(name = "轮换数量")
    private Long outStock;

    /** 存储合同Id */
    @Excel(name = "存储合同Id")
    private Long contractId;

}
