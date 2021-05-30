package com.grainoil.system.domain.vo.rotate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.page.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: yyl
 */
@Data
@ApiModel(description = "分页查询条件")
public class BatchPlanPageDto extends PageQuery {

    @ApiModelProperty(name = "batchCode",value = "计划编号")
    private String batchCode;

    @ApiModelProperty(name = "rotationType",value = "轮换类型")
    private String rotationType;

    @ApiModelProperty(name = "applyTime",value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;

    @ApiModelProperty(name = "state",value = "审批状态")
    private String state;

    @ApiModelProperty(name = "organizeId", value = "承储企业id(登录用户为承储企业就不需要)")
    private Long organizeId;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "varietyId", value = "粮油品种id")
    private Long varietyId;
}
