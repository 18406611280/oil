package com.grainoil.system.domain.quality.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: chenminghong
 * @Date: 2021/5/24 9:51
 */
@Data
@ApiModel
public class InventoryDto {

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    @NotBlank(message = "粮库不能为空")
    private Long grainDepotId;

    @ApiModelProperty(value="仓房id",name="storehouse_id")
    @NotBlank(message = "仓房不能为空")
    private Long storehouseId;

    @ApiModelProperty(name = "heapId",value = "堆位id")
    @NotBlank(message = "堆位不能为空")
    private Long heapId;

    @ApiModelProperty(name = "childHeapId",value = "子堆位id")
    private Long childHeapId;
}
