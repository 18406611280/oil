package com.grainoil.system.domain.vo.in_warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/17 17:17
 */
@Data
@ApiModel("入仓单查看视图")
public class InWarehouseVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "入仓单id")
    private Long id;

    @ApiModelProperty(name = "inWarehouseCode", value = "入仓单编号")
    private String inWarehouseCode;

    @ApiModelProperty(name = "organizeName", value = "承储企业")
    private String organizeName;

    @ApiModelProperty(name = "organizeId", value = "承储企业id")
    private Long organizeId;

    @ApiModelProperty(name = "warehousingType", value = "入库类型")
    private String warehousingType;

    @ApiModelProperty(name = "batchCode", value = "计划批次号(存储合同、轮入计划)")
    private String batchCode;

    @ApiModelProperty(name = "batchId", value = "计划批次id(存储合同、轮入计划)")
    private Long batchId;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName", value = "仓房名称")
    private String storehouseName;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "grade", value = "粮食等级")
    private String grade;

    @ApiModelProperty(name = "varietyId", value = "粮食品种id")
    private Long varietyId;

    @ApiModelProperty(name = "variety", value = "粮食品种")
    private String variety;

    @ApiModelProperty(name = "childVarieties", value = "小品种_新")
    private String childVarieties;

    @ApiModelProperty(name = "quantity", value = "数量")
    private Double quantity;

    @ApiModelProperty(name = "price", value = "购入价格")
    private Double price;

    @ApiModelProperty(name = "producingArea", value = "产地")
    private String producingArea;

    @ApiModelProperty(name = "producingProvince", value = "产地_省")
    private String producingProvince;

    @ApiModelProperty(name = "country", value = "国家")
    private String country;

    @ApiModelProperty(name = "packing", value = "包装方式")
    private String packing;

    @ApiModelProperty(name = "packingMaterial", value = "包装材料")
    private String packingMaterial;

    @ApiModelProperty(name = "packingNumber", value = "包数")
    private Long packingNumber;

    @ApiModelProperty(name = "particularYear", value = "生产年份")
    private String particularYear;

    @ApiModelProperty(name = "alreadyQuantity", value = "已入库数量")
    private Double alreadyQuantity;

    @ApiModelProperty(name = "percent", value = "完成比例")
    private Double percent;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "detailed", value = "入仓单明细")
    private List<InWarehouseDetailVo> detailed;

}
