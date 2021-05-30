package com.grainoil.system.domain.vo.in_warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/24 6:34
 */
@Data
@ApiModel("入仓单录入明细添加按钮")
public class ListVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName", value = "仓房名称")
    private String storehouseName;

    @ApiModelProperty(name = "heapId", value = "堆位id")
    private Long heapId;

    @ApiModelProperty(name = "heapName", value = "堆位编码")
    private String heapName;

    @ApiModelProperty(name = "childHeapId", value = "子堆id")
    private Long childHeapId;

    @ApiModelProperty(name = "childHeapCode", value = "子堆编号")
    private String childHeapCode;

    @ApiModelProperty(name = "quantity", value = "当前库存（吨）")
    private Double previousStock;

    @ApiModelProperty(name = "capacity", value = "堆位容量")
    private Double capacity;

    @ApiModelProperty(name = "type", value = "当前库存和堆位容量是否相等,1 相等, 0 不相等")
    private String type;
}
