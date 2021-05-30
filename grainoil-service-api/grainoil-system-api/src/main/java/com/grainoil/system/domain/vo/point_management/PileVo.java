package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@ApiModel(value = "PileVo", description = "堆位新增和编辑")
@Data
public class PileVo implements Serializable {

    private static final long   serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "堆位id(添加堆位时不需要)")
    private Long id;

    @ApiModelProperty(name = "pileCode", value = "堆位编码", required = true)
    @NotBlank(message = "堆位编码为必填项")
    private String pileCode;

    @ApiModelProperty(name = "pileCapacity", value = "设计容量", required = true)
    @NotNull(message = "设计容量为必填项")
    private Double pileCapacity;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "storehouseId", value = "所属仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "packMethod", value = "包装方式(数字字典)")
    private String packMethod;

    @ApiModelProperty(name = "pileState", value = "堆位状态(添加和修改堆位时都不需要)")
    private String pileState;
}
