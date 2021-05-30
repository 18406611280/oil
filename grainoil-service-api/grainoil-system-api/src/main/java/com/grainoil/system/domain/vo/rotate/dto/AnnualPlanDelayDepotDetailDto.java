package com.grainoil.system.domain.vo.rotate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/28 9:20
 */
@Data
@ApiModel("延期轮换库存清单")
public class AnnualPlanDelayDepotDetailDto implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "计划库存清单")
    private Long id;

    /**
     * 年度轮换计划id
     */
    @JsonIgnore
    private Long annualPlanDetailedId;

    /**
     * 粮库id
     */
    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    /**
     * 粮库
     */
    @JsonIgnore
    private String grainDepotName;

    /**
     * 仓房id
     */
    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    /**
     * 仓房
     */
    @JsonIgnore
    private String storehouseName;

    /**
     * 堆位id
     */
    @ApiModelProperty(name = "heapId", value = "堆位id")
    private Long heapId;

    /**
     * 子堆id
     */
    @ApiModelProperty(name = "childHeapId", value = "子堆id")
    private Long childHeapId;

    /**
     * 子堆编号
     */
    @JsonIgnore
    private String childHeapCode;

    /**
     * 堆位名
     */
    @JsonIgnore
    private String heapName;

    /**
     * 粮食品种
     */
    @JsonIgnore
    private String foodstuffTpye;

    /**
     * 产地
     */
    @ApiModelProperty(name = "producingArea", value = "产地")
    private String producingArea;

    /**
     * 入库时间
     */
    @ApiModelProperty(name = "moveInDate", value = "入库时间")
    private String moveInDate;

    /**
     * 库存数量
     */
    @ApiModelProperty(name = "stock", value = "库存数量")
    private Double stock;

    /**
     * 轮换数量
     */
    @ApiModelProperty(name = "rotationQuantity", value = "轮换数量")
    private Double rotationQuantity;

    /**
     * 存放方式
     */
    @ApiModelProperty(name = "depositType", value = "存放方式")
    private String depositType;

    /**
     * 是否延期储存
     */
    @ApiModelProperty(name = "isDelayed", value = "是否延期储存")
    private String isDelayed;

    /**
     * 延期储存数量
     */
    @ApiModelProperty(name = "delayedStorage", value = "延期储存数量")
    private Double delayedStorage;

    /**
     * remark
     */
    @ApiModelProperty(name = "remark", value = "remark")
    private String remark;
}
