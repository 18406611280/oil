package com.grainoil.system.domain.vo.in_warehouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author song
 * @date create in 21/5/24 16:14
 */
@Data
@ApiModel("入仓明细表集合")
public class ListDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "明细表id(添加的行记录不需要传或者传null)")
    private Long id;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id", required = true)
    @NotNull(message = "粮库id不能为空")
    private Long grainDepotId;

    @JsonIgnore
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId", value = "仓房id", required = true)
    @NotNull(message = "仓房id不能为空")
    private Long storehouseId;

    @JsonIgnore
    private String storehouseName;

    @ApiModelProperty(name = "heapId", value = "堆位id", required = true)
    @NotNull(message = "堆位id不能为空")
    private Long heapId;

    @JsonIgnore
    private String heapName;

    @ApiModelProperty(name = "childHeapId", value = "子堆id")
    private Long childHeapId;

    @JsonIgnore
    private String childHeapCode;

    @ApiModelProperty(name = "previousStock", value = "上次结余库存(当前库存)", required = true)
    @NotNull(message = "上次结余库存不能为空")
    @Min(value = 0, message = "上次结余库存最小值为0")
    private Double previousStock;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "warehouseDate", value = "入仓日期", required = true)
    @NotNull(message = "入仓日期不能为空")
    private Date warehouseDate;

    @ApiModelProperty(name = "quantity", value = "当次入仓数量", required = true)
    @NotNull(message = "当次入仓数量不能为空")
    private Double quantity;

    @ApiModelProperty(name = "numbers", value = "包数")
    private Long numbers;

    @ApiModelProperty(name = "enclosure", value = "文件id字符串,以逗号隔开")
    private String enclosure;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
