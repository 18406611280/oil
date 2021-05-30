package com.grainoil.system.domain.vo.rotate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(description = "日常轮换申请单-修改")
public class BatchPlanInfo implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "日常轮换申请单id")
    private Long id;

    @ApiModelProperty(name = "batchPlanId",value = "轮换申请id")
    private Long batchPlanId;

    /**
     * 轮出粮食品种
     */
    @ApiModelProperty(name = "foodstuffTpye",value = "轮出粮食品种")
    private String foodstuffTpye;

    /**
     *  轮出数量
     */
    @ApiModelProperty(name = "outStock",value = "轮出数量")
    private Double outStock;

    /**
     * 轮出粮库
     */
    @ApiModelProperty(name = "grainDepotName",value = "轮出粮库")
    private String grainDepotName;

    /**
     * 预计销售价格
     */
    @ApiModelProperty(name = "salePrice",value = "预计销售价格")
    private Double salePrice;

    /**
     * 出库开始时间
     */
    @ApiModelProperty(name = "removeBeginDate",value = "出库开始时间")
    private Date removeBeginDate;

    /**
     * 出库结束时间
     */
    @ApiModelProperty(name = "removeEndDate",value = "出库结束时间")
    private Date removeEndDate;

    /**
     * 出库时间
     */
    @ApiModelProperty(name = "removeDateList",value = "出库时间")
    private List<String> removeDateList;

    /**
     * 轮入粮食品种
     */
    @ApiModelProperty(name = "foodstuffTpye2",value = "轮入粮食品种")
    private String foodstuffTpye2;

    /**
     * 轮入数量
     */
    @ApiModelProperty(name = "inStock",value = "轮入数量")
    private Double inStock;

    /**
     * 轮入粮库id
     */
    @ApiModelProperty(name = "grainDepotId2",value = "轮入粮库id")
    private Long grainDepotId2;

    /**
     * 轮入粮库名称
     */
    @ApiModelProperty(name = "grainDepotName2",value = "轮入粮库名称")
    private String grainDepotName2;

    /**
     * 预计购入价格
     */
    @ApiModelProperty(name = "buyPrice",value = "预计购入价格")
    private Double buyPrice;

    /**
     * 入库开始时间
     */
    @ApiModelProperty(name = "moveInBeginDate",value = "入库开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date moveInBeginDate;

    /**
     * 入库结束时间
     */
    @ApiModelProperty(name = "moveInEndDate",value = "入库结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date moveInEndDate;

    /**
     * 入库时间
     */
    @ApiModelProperty(name = "moveInDateList",value = "入库时间")
    private List<String> moveInDateList;

    /**
     * 库存轮换清单列表
     */
    @ApiModelProperty(name = "batchPlanDepotInfoList",value = "库存轮换清单列表")
    private List<BatchPlanDepotInfo> batchPlanDepotInfoList;
}
