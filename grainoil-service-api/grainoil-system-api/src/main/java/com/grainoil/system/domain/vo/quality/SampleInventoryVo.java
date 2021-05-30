package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 14:12
 */
@Data
@ApiModel(value="SampleInventoryVo",description="粮库实际存储信息")
public class SampleInventoryVo {

    @ApiModelProperty(value="id",name="id")
    private Long id;

    /**
     * 粮库id
     */
    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Integer grainDepotId;

    /**
     * 粮库
     */
    @ApiModelProperty(value="粮库",name="grainDepotName")
    private String grainDepotName;

    /**
     * 仓房id
     */
    @ApiModelProperty(name = "storehouseId",value = "仓房id")
    private Integer storehouseId;

    /**
     * 仓房
     */
    @ApiModelProperty(value="仓房",name="storehouseName")
    private String storehouseName;

    /**
     * 堆位id
     */
    @ApiModelProperty(name = "heapId",value = "堆位id")
    private Integer heapId;

    /**
     * 堆位名
     */
    @ApiModelProperty(value="堆位名",name="heapName")
    private String heapName;

    /**
     * 包装方式
     */
    @ApiModelProperty(value="包装方式",name="packing")
    private String packing;

    /**
     * 包装材料
     */
    @ApiModelProperty(value="包装材料",name="packingType")
    private String packingType;

    /**
     * 粮食品种_id
     */
    @ApiModelProperty(name = "varietyId",value = "粮食品种_id")
    private Integer varietyId;

    /**
     * 粮食品种
     */
    @ApiModelProperty(value="粮食品种",name="variety")
    private String variety;

    /**
     * 数量
     */
    @ApiModelProperty(value="数量",name="quantity")
    private Double quantity;

    /**
     * 生产年份
     */
    @ApiModelProperty(value="生产年份",name="particularYear")
    private String particularYear;

    /**
     * 入库时间
     */
    @ApiModelProperty(value="入库时间",name="warehouseDate")
    private String warehouseDate;

    /**
     * 轮换批次号
     */
    @ApiModelProperty(value="轮换批次号",name="batchCode")
    private String batchCode;

}
