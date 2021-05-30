package com.grainoil.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TbBatchPlanInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 轮换批次id */
    private Long batchPlanId;

    /** 轮出粮库id */
    private Long grainDepotId;

    /** 轮出粮库 */
    private String grainDepotName;

    /** 轮出粮食品种 */
    private String foodstuffTpye;

    /** 出库开始时间 */
    private Date removeBeginDate;

    /** 出库结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date removeEndDate;

    /** 出库数量 */
    private Long outStock;

    /** 预计销售价格 */
    private Long salePrice;

    /** 轮入品种 */
    private String foodstuffTpye2;

    /** 入库开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date moveInBeginDate;

    /** 入库结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date moveInEndDate;

    /** 入库数量 */
    private Long inStock;

    /** 预计购入价格 */
    private Long buyPrice;

    /** 轮入粮库id */
    private Long grainDepotId2;

    /** 轮入粮库2 */
    private String grainDepotName2;

    /** 变更状态(变更前或者后的数据) */
    private String changeState;

    /** 变更备注 */
    private String changeRemark;

    /** 变更时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date changeTime;

    /** 变更前累计轮入数量 */
    private Long changeInTotal;

    /** 变更前累计轮出数量 */
    private Long changeOutTotal;
}
