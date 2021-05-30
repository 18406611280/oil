package com.grainoil.system.domain.quality.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.page.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 15:21
 */
@Data
@ApiModel
public class QualityReportPageDto extends PageQuery {

    @ApiModelProperty(name = "sampleCode",value = "样品编号")
    private String sampleCode;

    @ApiModelProperty(value="申请编号",name="applyCode")
    private String applyCode;

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Long grainDepotId;

    @ApiModelProperty(value="仓房id",name="storehouse_id")
    private Long storehouseId;

    @ApiModelProperty(value="申请开始时间",name="applyStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyStartDate;

    @ApiModelProperty(value="申请结束时间",name="applyEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyEndDate;

    @ApiModelProperty(value="轮换编号",name="batchCode")
    private String batchCode;

    @ApiModelProperty(value="存储企业id",name="organizeId")
    private Long organizeId;


}
