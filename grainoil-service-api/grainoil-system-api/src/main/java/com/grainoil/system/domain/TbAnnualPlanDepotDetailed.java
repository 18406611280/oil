package com.grainoil.system.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbAnnualPlanDepotDetailed implements Serializable {

    public static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;

    /**
    * 年度轮换计划id
    */
    private Long annualPlanDetailedId;

    /**
    * 粮库id
    */
    private Long grainDepotId;

    /**
    * 粮库
    */
    private String grainDepotName;

    /**
    * 仓房id
    */
    private Long storehouseId;

    /**
    * 仓房
    */
    private String storehouseName;

    /**
    * 堆位id
    */
    private Long heapId;

    /**
    * 子堆id
    */
    private Long childHeapId;

    /**
    * 子堆编号
    */
    private String childHeapCode;

    /**
    * 堆位名
    */
    private String heapName;

    /**
    * 粮食品种
    */
    private String foodstuffTpye;

    /**
    * 产地
    */
    private String producingArea;

    /**
    * 入库时间
    */
    private String moveInDate;

    /**
    * 库存数量
    */
    private Double stock;

    /**
    * 轮换数量
    */
    private Double rotationQuantity;

    /**
    * 存放方式
    */
    private String depositType;

    /**
    * 是否延期储存
    */
    private String isDelayed;

    /**
    * 延期储存数量
    */
    private Double delayedStorage;

    /**
    * 备注
    */
    private String remark;

    /**
    * 存储合同Id
    */
    private Long contractId;

}