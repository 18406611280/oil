package com.grainoil.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.annotation.Excel;
import com.grainoil.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TbRelocation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 市(区)粮管中心id(粮权) */
    @Excel(name = "市(区)粮管中心id(粮权)")
    private Long grainOrganizeId;

    /** 粮管中心名称 */
    @Excel(name = "粮管中心名称")
    private String grainOrganizeName;

    /** 承储企业名称 */
    @Excel(name = "承储企业名称")
    private String organizeName;

    /** 承储企业id */
    @Excel(name = "承储企业id")
    private Long organizeId;

    /** 移库粮库id */
    @Excel(name = "移库粮库id")
    private Long removeGrainDepotId;

    /** 移库粮库 */
    @Excel(name = "移库粮库")
    private String removeGrainDepot;

    /** 承储数量 */
    @Excel(name = "承储数量")
    private Double contractQuantity;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Double stock;

    /** 移入粮库id */
    @Excel(name = "移入粮库id")
    private Long moveInGrainDepotId;

    /** 移入粮库 */
    @Excel(name = "移入粮库")
    private String moveInGrainDepot;

    /** 移库开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "移库开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /** 移库结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "移库结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 移出数量 */
    @Excel(name = "移出数量")
    private Double removeQuantity;

    /** 移库批文编号 */
    @Excel(name = "移库批文编号")
    private String documentNumber;

    /** 移库批文附件 */
    @Excel(name = "移库批文附件")
    private String enclosure;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 是否删除 */
    private String delFlag;

    /** 创建id */
    @Excel(name = "创建id")
    private Long createId;

    /** 更新人id */
    @Excel(name = "更新人id")
    private Long updateId;

}
