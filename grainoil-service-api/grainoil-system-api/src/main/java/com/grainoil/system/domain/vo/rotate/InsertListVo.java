package com.grainoil.system.domain.vo.rotate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/24 6:24
 */
@Data
@ApiModel("年度轮换计划添加按钮列表视图")
public class InsertListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    @ApiModelProperty(name = "grainDepotId",value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName",value = "粮库")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId",value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName",value = "仓房")
    private String storehouseName;

    @ApiModelProperty(name = "heapId",value = "堆位id")
    private Long heapId;

    @ApiModelProperty(name = "heapName",value = "堆位名")
    private String heapName;

    @ApiModelProperty(name = "childHeapId",value = "子堆id")
    private Long childHeapId;

    @ApiModelProperty(name = "childHeapCode",value = "子堆编号")
    private String childHeapCode;

    @ApiModelProperty(name = "varietyId",value = "粮食品种_id")
    private Long varietyId;

    @ApiModelProperty(name = "variety",value = "粮食品种")
    private String variety;

    @ApiModelProperty(name = "childVarieties",value = "小品种")
    private String childVarieties;

    @ApiModelProperty(name = "quantity",value = "数量")
    private Double quantity;

    @ApiModelProperty(name = "producingArea",value = "产地")
    private String producingArea;

    @ApiModelProperty(name = "packing",value = "包装方式")
    private String packing;

    @ApiModelProperty(name = "warehouseDate",value = "入库时间")
    private String warehouseDate;

}
