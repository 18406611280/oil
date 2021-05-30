package com.grainoil.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.annotation.Excel;
import com.grainoil.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TbBatchPlanChange extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 变更顺序 */
    @Excel(name = "变更顺序")
    private Long order;

    /** 轮换批次id */
    @Excel(name = "轮换批次id")
    private Long batchPlanId;

    /** 轮换开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "轮换开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date removeBeginDate;

    /** 轮换结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "轮换结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date removeEndDate;

    /** 变更轮换数量 */
    @Excel(name = "变更轮换数量")
    private Double outStock;

    /** 变更备注 */
    @Excel(name = "变更备注")
    private String changeRemark;

    /** 变更时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "变更时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date changeTime;

    /** 变更前累计轮入数量 */
    @Excel(name = "变更前累计轮入数量")
    private Double changeInTotal;

    /** 变更前累计轮出数量 */
    @Excel(name = "变更前累计轮出数量")
    private Double changeOutTotal;

    public TbBatchPlanChange() {
    }

    public TbBatchPlanChange(Long order, Long batchPlanId, Date removeBeginDate,
                             Date removeEndDate, Double outStock, String changeRemark, Date changeTime,
                             Double changeInTotal, Double changeOutTotal) {
        this.order = order;
        this.batchPlanId = batchPlanId;
        this.removeBeginDate = removeBeginDate;
        this.removeEndDate = removeEndDate;
        this.outStock = outStock;
        this.changeRemark = changeRemark;
        this.changeTime = changeTime;
        this.changeInTotal = changeInTotal;
        this.changeOutTotal = changeOutTotal;
    }
}
