package com.grainoil.system.domain.quality.dto;

import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/24 11:56
 */
@Data
@ApiModel
public class DailySampleQualityAddDto {

    @ApiModelProperty(name = "inventoryId",value = "粮库信息id")
    private Long inventoryId;

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Long grainDepotId;

    @ApiModelProperty(name = "foodCheckItemVos",value = "质检项")
    private List<FoodCheckItemVo> foodCheckItemVos;

    @ApiModelProperty(name = "Result",value = "判定")
    private String Result;
}