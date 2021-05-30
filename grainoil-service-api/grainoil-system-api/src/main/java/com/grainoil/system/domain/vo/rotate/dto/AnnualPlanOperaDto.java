package com.grainoil.system.domain.vo.rotate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/27 17:33
 */
@Data
@ApiModel("添加/编辑/调增年度轮换计划入参")
public class AnnualPlanOperaDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "年度轮换计划id(添加的记录不需要id)")
    private Long id;

    @JsonIgnore
    private String annualBatchCode;

    @JsonIgnore
    private Long organizeId;

    /**
     * 市(区)粮管中心id(粮权)
     */
    @JsonIgnore
    private Long grainOrganizeId;

    /**
     * 粮管中心名称
     */
    @JsonIgnore
    private String grainOrganizeName;

    /**
     * 承储企业
     */
    @JsonIgnore
    private String organizeName;

    /**
     * 年份
     */
    @JsonIgnore
    private String particularYear;

    /**
     * 状态
     */
    @JsonIgnore
    private String state;

    /**
     * 延期储存材料id
     */
    @ApiModelProperty(name = "fileId", value = "延期储存材料id")
    private Long fileId;

    /**
     * 申请时间
     */
    @JsonIgnore
    private Date applyTime;

    /**
     * 申请人
     */
    @JsonIgnore
    private Long applyId;

    @ApiModelProperty(name = "details", value = "计划清单", required = true)
    private List<AnnualPlanDetailDto> details;

    @ApiModelProperty(name = "depotDetails", value = "轮换库存清单", required = true)
    private List<AnnualPlanDepotDetailDto> depotDetails;

    @ApiModelProperty(name = "delayDepotDetails", value = "延期轮换库存清单", required = true)
    private List<AnnualPlanDelayDepotDetailDto> delayDepotDetails;
}
