package com.grainoil.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TbGrainActualInventory {
    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    /**
     * 粮权所属市或者区id
     */
    @ApiModelProperty(name = "grainOwnerId",value = "粮权所属市或者区id")
    private Long grainOwnerId;

    /**
     * 粮权所属市或者区名称
     */
    @ApiModelProperty(name = "grainOwnerName",value = "粮权所属市或者区名称")
    private String grainOwnerName;

    /**
     * 承储企业
     */
    @ApiModelProperty(name = "organizeName",value = "承储企业")
    private String organizeName;

    /**
     * 承储企业id
     */
    @ApiModelProperty(name = "organizeId",value = "承储企业id")
    private Long organizeId;

    /**
     * 粮库id
     */
    @ApiModelProperty(name = "grainDepotId",value = "粮库id")
    private Long grainDepotId;

    /**
     * 粮库
     */
    @ApiModelProperty(name = "grainDepotName",value = "粮库")
    private String grainDepotName;

    /**
     * 仓房id
     */
    @ApiModelProperty(name = "storehouseId",value = "仓房id")
    private Long storehouseId;

    /**
     * 仓房
     */
    @ApiModelProperty(name = "storehouseName",value = "仓房")
    private String storehouseName;

    /**
     * 堆位id
     */
    @ApiModelProperty(name = "heapId",value = "堆位id")
    private Long heapId;

    /**
     * 堆位名
     */
    @ApiModelProperty(name = "heapName",value = "堆位名")
    private String heapName;

    /**
     * 子堆id
     */
    @ApiModelProperty(name = "childHeapId",value = "子堆id")
    private Long childHeapId;

    /**
     * 子堆编号
     */
    @ApiModelProperty(name = "childHeapCode",value = "子堆编号")
    private String childHeapCode;

    /**
     * 堆位状态(子堆不为空时为子堆状态，子堆为空时为堆状态）
     */
    @ApiModelProperty(name = "heapState",value = "堆位状态(子堆不为空时为子堆状态，子堆为空时为堆状态）")
    private String heapState;

    /**
     * 粮食品种_id
     */
    @ApiModelProperty(name = "varietyId",value = "粮食品种_id")
    private Long varietyId;

    /**
     * 粮食等级
     */
    @ApiModelProperty(name = "grade",value = "粮食等级")
    private String grade;

    /**
     * 粮食品种
     */
    @ApiModelProperty(name = "variety",value = "粮食品种")
    private String variety;

    /**
     * 小品种
     */
    @ApiModelProperty(name = "childVarieties",value = "小品种")
    private String childVarieties;

    /**
     * 数量
     */
    @ApiModelProperty(name = "quantity",value = "数量")
    private Double quantity;

    /**
     * 购入价格
     */
    @ApiModelProperty(name = "price",value = "购入价格")
    private Double price;

    /**
     * 产地
     */
    @ApiModelProperty(name = "producingArea",value = "产地")
    private String producingArea;

    /**
     * 包装方式
     */
    @ApiModelProperty(name = "packing",value = "包装方式")
    private String packing;

    /**
     * 包装材料
     */
    @ApiModelProperty(name = "packingType",value = "包装材料")
    private String packingType;

    /**
     * 袋数
     */
    @ApiModelProperty(name = "bagsCount",value = "袋数")
    private Long bagsCount;

    /**
     * 生产年份
     */
    @ApiModelProperty(name = "particularYear",value = "生产年份")
    private String particularYear;

    /**
     * 入库类型
     */
    @ApiModelProperty(name = "warehousingType",value = "入库类型")
    private String warehousingType;

    /**
     * 入库开始时间
     */
    @ApiModelProperty(name = "warehouseStartDate",value = "入库开始时间")
    private Date warehouseStartDate;

    /**
     * 入库结束时间
     */
    @ApiModelProperty(name = "warehouseEndDate",value = "入库结束时间")
    private Date warehouseEndDate;

    /**
     * 申请质检时间
     */
    @ApiModelProperty(name = "applyDate",value = "申请质检时间")
    private Date applyDate;

    /**
     * 存储到期时间
     */
    @ApiModelProperty(name = "dueDate",value = "存储到期时间")
    private Date dueDate;

    /**
     * 质检报告时间
     */
    @ApiModelProperty(name = "reportTime",value = "质检报告时间")
    private Date reportTime;

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createBy",value = "创建人")
    private String createBy;

    /**
     * 创建id
     */
    @ApiModelProperty(name = "createId",value = "创建id")
    private Long createId;

    /**
     * 创建日期
     */
    @ApiModelProperty(name = "createTime",value = "创建日期")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateBy",value = "更新人")
    private String updateBy;

    /**
     * 更新人id
     */
    @ApiModelProperty(name = "updateId",value = "更新人id")
    private Long updateId;

    /**
     * 更新日期
     */
    @ApiModelProperty(name = "updateTime",value = "更新日期")
    private Date updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty(name = "delFlag",value = "是否删除")
    private String delFlag;

    /**
     * 轮换计划或者存储合同id
     */
    @ApiModelProperty(name = "contractId",value = "轮换计划或者存储合同id")
    private Long contractId;

    /**
     * 轮换批次号
     */
    @ApiModelProperty(name = "batchCode",value = "轮换批次号")
    private String batchCode;

    /**
     * （出）入仓单Id
     */
    @ApiModelProperty(name = "receiptId",value = "（出）入仓单Id")
    private Long receiptId;
}