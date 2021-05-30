package com.grainoil.system.domain.vo.rotate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 申请日常轮换计划列表实体
 * @author yyl
 * @date
 */
@Data
@ApiModel(description = "申请日常轮换计划列表")
public class BatchPlanEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "日常轮换id")
    private Long id;

    /**
     * 轮换编号
     */
    @ApiModelProperty(name = "batchCode",value = "轮换编号")
    private String batchCode;

    /**
     * 轮换类型
     */
    @ApiModelProperty(name = "rotationType",value = "轮换类型")
    private String rotationType;

    /**
     * 申请时间
     */
    @ApiModelProperty(name = "applyTime",value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;

    /**
     * 审批状态
     */
    @ApiModelProperty(name = "state",value = "审批状态")
    private String state;

    /**
     * 排序
     */
    @ApiModelProperty(name = "sort",value = "排序")
    private Integer sort;

    /** 以下字段不做数据库处理*/
    @ApiModelProperty(name = "grainDepotName",value = "轮出粮库名称")
    private String grainDepotName ; //轮出粮库名称
    @ApiModelProperty(name = "foodstuffTpye",value = "轮出粮食品种")
    private String foodstuffTpye ; //轮出粮食品种
    @ApiModelProperty(name = "outStock",value = "出库数量")
    private String outStock ; //出库数量
    @ApiModelProperty(name = "grainDepotName2",value = "轮入粮库2")
    private String grainDepotName2 ; //轮入粮库2
    @ApiModelProperty(name = "foodstuffTpye2",value = "轮入品种")
    private String foodstuffTpye2 ; //轮入品种
    @ApiModelProperty(name = "inStock",value = "入库数量")
    private String inStock; //入库数量
}
