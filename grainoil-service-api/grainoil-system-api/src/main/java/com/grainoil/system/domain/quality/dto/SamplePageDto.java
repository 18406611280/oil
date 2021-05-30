package com.grainoil.system.domain.quality.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.page.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/21 16:21
 */
@Data
@ApiModel(description = "分页")
public class SamplePageDto extends PageQuery {

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Long grainDepotId;

    @ApiModelProperty(value="粮油品种id",name="varietyId")
    private Long varietyId;

    @ApiModelProperty(value="申请开始时间",name="applyStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyStartDate;

    @ApiModelProperty(value="申请结束时间",name="applyEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyEndDate;

    @ApiModelProperty(value="入库开始时间",name="warehouseStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date warehouseStartDate;

    @ApiModelProperty(value="出库结束时间",name="warehouseEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date warehouseEndDate;

    @ApiModelProperty(value="申请编号",name="applyCode")
    private String applyCode;

    @ApiModelProperty(value="轮换编号",name="batchCode")
    private String batchCode;
}
