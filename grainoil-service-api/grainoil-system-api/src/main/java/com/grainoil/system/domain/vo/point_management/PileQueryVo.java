package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@ApiModel(value = "PileQueryVo", description = "堆位查询条件")
@Data
public class PileQueryVo implements Serializable {

    private static final long   serialVersionUID = 1L;

    @ApiModelProperty(name = "storehouseId", value = "所属仓房id", required = true)
    @NotNull(message = "所属仓房id不能为空")
    private Long storehouseId;

}
