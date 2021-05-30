package com.grainoil.system.domain.quality.dto;

import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/25 17:32
 */
@Data
@ApiModel
public class QualityReportAddDto {

    @ApiModelProperty(name = "sampleId",value = "样品id")
    private Long sampleId;

    @ApiModelProperty(name = "foodCheckItemVos",value = "质检项")
    private List<FoodCheckItemVo> foodCheckItemVos;
}
