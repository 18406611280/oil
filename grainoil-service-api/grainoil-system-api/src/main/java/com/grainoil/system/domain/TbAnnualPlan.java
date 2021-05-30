package com.grainoil.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbAnnualPlan implements Serializable {

    public static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;

    /**
    * 年轮换计划批次号
    */
    private String annualBatchCode;

    /**
    * 承储企业id
    */
    private Long organizeId;

    /**
    * 市(区)粮管中心id(粮权)
    */
    private Long grainOrganizeId;

    /**
    * 粮管中心名称
    */
    private String grainOrganizeName;

    /**
    * 承储企业
    */
    private String organizeName;

    /**
    * 年份
    */
    private String particularYear;

    /**
    * 状态
    */
    private String state;

    /**
    * 延期储存材料id
    */
    private Long fileId;

    /**
    * 申请时间
    */
    private Date applyTime;

    /**
    * 申请人
    */
    private Long applyId;

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