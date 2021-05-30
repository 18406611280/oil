package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="FoodStuffCheckVo",description="粮油品种列表")
public class FoodStuffCheckVo implements Serializable {


    /**
     * 品种id
     */
    @ApiModelProperty(value="品种id",name="varietyId",required=true)
    @NotNull
    private Long varietyId;

    /**
     * 品种名称
     */
    @ApiModelProperty(value="品种名称",name="variety",required=true)
    @NotNull
    private String variety;

    /**
     * 质检配置
     */
    @ApiModelProperty(value="质检配置",name="foodCheckVoList",required=true)
    private List<FoodCheckVo> foodCheckVoList;

}
