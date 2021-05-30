package com.grainoil.system.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TbAnnualPlanDetailed {
    /**
    * id
    */
    private Long id;

    /**
    * 市(区)粮管中心id(粮库所在区)
    */
    private Long grainOrganizeId;

    /**
    * 粮管中心名称
    */
    private String grainOrganizeName;

    /**
    * 年度轮换申请id
    */
    private Long annualPlan;

    /**
    * 粮食品种
    */
    private String foodstuffTpye;

    /**
    * 粮库id
    */
    private Long grainDepotId;

    /**
    * 粮库所在区
    */
    private String grainDepotRegion;

    /**
    * 粮库
    */
    private String grainDepotName;

    /**
    * 已达储存期限的数量
    */
    private Double reachedLifeStorage;

    /**
    * 延期储存数量
    */
    private Double delayedStorage;

    /**
    * 承储数量
    */
    private Double quantityStorage;

    /**
    * 轮换数量
    */
    private Double rotationQuantity;

    /**
    * 备注
    */
    private String remark;

    /**
    * 是否删除
    */
    private String delFlag;

    /**
    * 创建id
    */
    private Long createId;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 更新人id
    */
    private Long updateId;

    /**
    * 更新人
    */
    private String updateBy;

    /**
    * 更新日期
    */
    private Date updateTime;

}