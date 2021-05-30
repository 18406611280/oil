package com.grainoil.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.page.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 15:51
 */
@Data
@ApiModel
public class BiddingDeliveryPageDto extends PageQuery {

    /**
     * 存储企业id
     */
    @ApiModelProperty(name = "organizeId",value = "存储企业id")
    private Long organizeId;

    /**
     * 批文编号
     */
    @ApiModelProperty(name = "contractCode",value = "批文编号")
    private String contractCode;

    /**
     * 存储合同编号
     */
    @ApiModelProperty(name = "storageContractCode",value = "存储合同编号")
    private String storageContractCode;

    /**
     * 存储开始时间
     */
    @ApiModelProperty(name = "beginDate",value = "存储开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    /**
     * 存储开始时间
     */
    @ApiModelProperty(name = "endDate",value = "存储结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;




}
