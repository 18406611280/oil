package com.grainoil.system.domain.vo.in_warehouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.page.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author song
 * @date create in 21/5/24 10:42
 */
@Data
@ApiModel("入仓通知单查询条件")
public class InWarehouseQuery extends PageQuery implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "varietyId", value = "粮食品种id")
    private Long varietyId;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "beginTime", value = "申请时间开始")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "endTime", value = "申请时间结束")
    private Date endTime;

    @ApiModelProperty(name = "inWarehouseCode", value = "入仓单编号")
    private String inWarehouseCode;

    @ApiModelProperty(name = "state", value = "状态")
    private String state;

    @ApiModelProperty(name = "batchCode", value = "批文编号")
    private String batchCode;

    @ApiModelProperty(name = "warehousingType", value = "入库类型")
    private String warehousingType;

    @ApiModelProperty(name = "organizeId", value = "承储企业id(登录用户为承储企业就不需要)")
    private Long organizeId;

}
