package com.grainoil.system.domain.vo.quality;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/20 15:35
 */
@Data
public class RegisterSampleVo {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "粮库信息id")
    private Long inventoryId;

    @ApiModelProperty(value = "样品名称")
    private String sampleName;

    @ApiModelProperty(value = "样品编号")
    private String sampleCode;

    @ApiModelProperty(value="粮库id",name="grainDepotId")
    private Integer grainDepotId;

    @ApiModelProperty(value="粮库",name="grainDepotName")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId",value = "仓房id")
    private Integer storehouseId;

    @ApiModelProperty(value="仓房",name="storehouseName")
    private String storehouseName;

    @ApiModelProperty(name = "heapId",value = "堆位id")
    private Integer heapId;

    @ApiModelProperty(value="堆位名",name="heapName")
    private String heapName;

    @ApiModelProperty(value="包装方式",name="packing")
    private String packing;

    @ApiModelProperty(value="包装材料",name="packingType")
    private String packingType;

    @ApiModelProperty(name = "varietyId",value = "粮食品种_id")
    private Integer varietyId;

    @ApiModelProperty(value="粮食品种",name="variety")
    private String variety;

    @ApiModelProperty(value="数量",name="quantity")
    private Double quantity;

    @ApiModelProperty(value="生产年份",name="particularYear")
    private String particularYear;

    @ApiModelProperty(value="入库时间",name="warehouseDate")
    private String warehouseDate;

    @ApiModelProperty(value="轮换批次号",name="batchCode")
    private String batchCode;

}
