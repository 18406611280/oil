package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/18 16:54
 */
@Data
@ApiModel("子堆入参")
public class ChildPileSplitDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "pileCode", value = "堆位编码", required = true)
    @NotBlank(message = "堆位编码为必填项")
    private String pileCode;

    @ApiModelProperty(name = "pileCapacity", value = "设计容量", required = true)
    @NotNull(message = "设计容量为必填项")
    @Min(value = 0, message = "最小库存容量为0")
    private Double pileCapacity;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
