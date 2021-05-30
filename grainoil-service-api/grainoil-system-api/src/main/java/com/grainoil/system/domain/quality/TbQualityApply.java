package com.grainoil.system.domain.quality;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TbQualityApply {
    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    /**
     * 粮权所属市或者区id
     */
    @ApiModelProperty(name = "grainOwnerId",value = "粮权所属市或者区id")
    private Long grainOwnerId;

    /**
     * 粮权所属市或者区名称
     */
    @ApiModelProperty(name = "grainOwnerName",value = "粮权所属市或者区名称")
    private String grainOwnerName;

    /**
     * 申请类型
     */
    @ApiModelProperty(name = "applyType",value = "申请类型")
    private String applyType;

    /**
     * 申请编号
     */
    @ApiModelProperty(name = "applyCode",value = "申请编号")
    private String applyCode;

    /**
     * 检验机构
     */
    @ApiModelProperty(name = "qualityOrg",value = "检验机构")
    private Long qualityOrg;

    /**
     * 承储企业id
     */
    @ApiModelProperty(name = "organizeId",value = "承储企业id")
    private Long organizeId;

    /**
     * 承储企业
     */
    @ApiModelProperty(name = "organizeName",value = "承储企业")
    private String organizeName;

    /**
     * 申请日期
     */
    @ApiModelProperty(name = "applyDate",value = "申请日期")
    private Date applyDate;

    /**
     * 扦样人
     */
    @ApiModelProperty(name = "samplers",value = "扦样人")
    private String samplers;

    /**
     * 粮库id
     */
    @ApiModelProperty(name = "grainDepotId",value = "粮库id")
    private Long grainDepotId;

    /**
     * 粮库
     */
    @ApiModelProperty(name = "grainDepotName",value = "粮库")
    private String grainDepotName;

    /**
     * 粮库地址
     */
    @ApiModelProperty(name = "grainDepotPosition",value = "粮库地址")
    private String grainDepotPosition;

    /**
     * 备注
     */
    @ApiModelProperty(name = "remark",value = "备注")
    private String remark;

    /**
     * 实际扦样日期
     */
    @ApiModelProperty(name = "actualSamplingDate",value = "实际扦样日期")
    private Date actualSamplingDate;

    /**
     * 状态
     */
    @ApiModelProperty(name = "state",value = "状态")
    private String state;

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createBy",value = "创建人")
    private String createBy;

    /**
     * 创建id
     */
    @ApiModelProperty(name = "createId",value = "创建id")
    private Long createId;

    /**
     * 创建日期
     */
    @ApiModelProperty(name = "createTime",value = "创建日期")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateBy",value = "更新人")
    private String updateBy;

    /**
     * 更新人id
     */
    @ApiModelProperty(name = "updateId",value = "更新人id")
    private Long updateId;

    /**
     * 更新日期
     */
    @ApiModelProperty(name = "updateTime",value = "更新日期")
    private Date updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty(name = "delFlag",value = "是否删除")
    private String delFlag;
}