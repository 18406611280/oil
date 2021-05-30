package com.grainoil.system.domain.vo.rotate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/28 6:58
 */
@Data
@ApiModel("计划清单")
public class AnnualPlanDetailDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "计划清单id(添加的记录不需要id)")
    private Long id;

    /**
     * 市(区)粮管中心id(粮库所在区)
     */
    @JsonIgnore
    private Long grainOrganizeId;

    /**
     * 粮管中心名称
     */
    @JsonIgnore
    private String grainOrganizeName;

    /**
     * 年度轮换申请id
     */
    @JsonIgnore
    private Long annualPlan;

    /**
     * 粮食品种
     */
    @JsonIgnore
    private String foodstuffTpye;

    /**
     * 粮库id
     */
    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    /**
     * 粮库所在区
     */
    @ApiModelProperty(name = "grainDepotRegion", value = "粮库所在区")
    private String grainDepotRegion;

    /**
     * 粮库
     */
    @JsonIgnore
    private String grainDepotName;

    /**
     * 已达储存期限的数量
     */
    @ApiModelProperty(name = "reachedLifeStorage", value = "已达储存期限的数量")
    private Double reachedLifeStorage;

    /**
     * 延期储存数量
     */
    @ApiModelProperty(name = "delayedStorage", value = "延期储存数量")
    private Double delayedStorage;

    /**
     * 承储数量
     */
    @ApiModelProperty(name = "quantityStorage", value = "承储数量")
    private Double quantityStorage;

    /**
     * 轮换数量
     */
    @ApiModelProperty(name = "rotationQuantity", value = "轮换数量")
    private Double rotationQuantity;

    /**
     * 备注
     */
    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
