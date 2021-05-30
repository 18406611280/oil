package com.grainoil.system.domain.vo.in_warehouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author song
 * @date create in 21/5/24 10:58
 */
@Data
@ApiModel("入仓单列表视图")
public class InWarehouseListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "id")
    private Long id;

    @ApiModelProperty(name = "inWarehouseCode", value = "入仓单编号")
    private String inWarehouseCode;

    @ApiModelProperty(name = "organizeName", value = "承储企业")
    private String organizeName;

    @ApiModelProperty(name = "warehousingType", value = "入库类型")
    private String warehousingType;

    @ApiModelProperty(name = "batchCode", value = "批文编号")
    private String batchCode;

    @ApiModelProperty(name = "storehouseName", value = "仓房")
    private String storehouseName;

    @ApiModelProperty(name = "grainDepotName", value = "粮库")
    private String grainDepotName;

    @ApiModelProperty(name = "variety", value = "粮食品种")
    private String variety;

    @ApiModelProperty(name = "quantity", value = "数量")
    private Double quantity;

    @ApiModelProperty(name = "producingArea", value = "产地")
    private String producingArea;

    @ApiModelProperty(name = "packing", value = "包装方式")
    private String packing;

    @ApiModelProperty(name = "particularYear", value = "生产年份")
    private String particularYear;

    @ApiModelProperty(name = "inTime", value = "入库时间")
    private String inTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "applyTime", value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(name = "state", value = "状态")
    private String state;

}
