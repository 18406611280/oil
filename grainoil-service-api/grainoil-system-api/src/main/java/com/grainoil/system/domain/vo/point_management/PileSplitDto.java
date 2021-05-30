package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/18 16:01
 */
@ApiModel("拆堆入参")
@Data
public class PileSplitDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "主堆位id", required = true)
    @NotNull(message = "主堆id不能为空")
    private Long id;

    @ApiModelProperty(name = "pileCode", value = "堆位编码", required = true)
    @NotBlank(message = "堆位编码为必填项")
    private String pileCode;

    @ApiModelProperty(name = "pileCapacity", value = "设计容量", required = true)
    @NotNull(message = "设计容量为必填项")
    @Min(value = 0, message = "最小库存容量为0")
    private Double pileCapacity;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "list", value = "子堆列表,至少两个", required = true)
    @NotEmpty(message = "子堆列表不能为空")
    private List<ChildPileSplitDto> list;
}
