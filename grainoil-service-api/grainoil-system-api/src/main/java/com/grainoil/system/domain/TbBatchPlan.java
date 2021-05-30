package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TbBatchPlan extends BaseEntity {
    public static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 年度轮换id
     */
    private Long annualPlan;

    /**
     * 移库批文Id(没有批文时，保存0)
     */
    private Long relocationId;

    /**
     * 承储企业id
     */
    private Long organizeId;

    /**
     * 轮换编号
     */
    private String batchCode;

    /**
     * 审批状态
     */
    private String state;

    /**
     * 是否提前终止
     */
    private String isAdvanceEnd;

    /**
     * 轮换类型
     */
    private String rotationType;

    /**
     * 市(区)粮管中心id(粮权)
     */
    private Long grainOrganizeId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 申请人
     */
    private Long applyId;

    /**
     * 粮管中心名称
     */
    private String grainOrganizeName;

    /**
     * 是否删除
     */
    private String delFlag;

    /** 以下字段不做数据库处理*/
    private String grainDepotName ; //轮出粮库名称
    private String foodstuffTpye ; //轮出粮食品种
    private String outStock ; //出库数量
    private String grainDepotName2 ; //轮入粮库2
    private String foodstuffTpye2 ; //轮入品种
    private String inStock; //入库数量
}
