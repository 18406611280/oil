package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/24 10:37
 */
@Data
@ApiModel("质检项")
public class FoodCheckItemVo {

    @ApiModelProperty(name = "checkItemId",value = "质检项id")
    private Long checkItemId;

    @ApiModelProperty(name = "termName",value = "质检项名称")
    private String termName;

    @ApiModelProperty(name = "standard",value = "标准")
    private String standard;

    @ApiModelProperty(name = "checkResult",value = "质检结果")
    private String checkResult;



}
