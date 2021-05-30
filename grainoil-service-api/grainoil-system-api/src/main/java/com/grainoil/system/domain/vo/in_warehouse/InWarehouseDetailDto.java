package com.grainoil.system.domain.vo.in_warehouse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/24 15:59
 */
@Data
@ApiModel("入仓单录入明细入参")
public class InWarehouseDetailDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "入仓通知单id", required = true)
    @NotNull(message = "入仓通知单id不能为空")
    private Long id;

    @JsonIgnore
    private String state;

    @ApiModelProperty(name = "deletes", value = "删除的入仓单id集合", required = true)
    @NotEmpty(message = "删除的入仓单id集合不能为空")
    private List<Long> deletes;

    @ApiModelProperty(name = "detailed", value = "录入明细集合", required = true)
    @NotNull(message = "录入明细不能为空")
    private List<ListDto> detailed;


}
