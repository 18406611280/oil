package com.grainoil.system.domain.vo.in_warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/17 16:51
 */
@ApiModel("审核入参")
@Data
public class AuditDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "入仓通知单id", required = true)
    @NotNull(message = "入仓通知单id不能为空")
    private Long id;

    @ApiModelProperty(name = "pass", value = "true 通过, false 不通过", required = true)
    @NotNull(message = "通过状态不能为空")
    private boolean pass;

    @ApiModelProperty(name = "result", value = "审批结果(通过/不通过)", required = true)
    @NotBlank(message = "审批结果不能为空")
    private String result;

    @ApiModelProperty(name = "idea", value = "意见", required = true)
    @NotBlank(message = "意见不能为空")
    private String idea;

    @ApiModelProperty(name = "ids", value = "选择的入仓单id集合")
    @NotEmpty(message = "选择的入仓单id集合不能为空")
    private List<Long> ids;

}
