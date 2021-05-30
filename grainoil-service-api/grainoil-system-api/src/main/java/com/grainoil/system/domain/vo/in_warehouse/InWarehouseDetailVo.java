package com.grainoil.system.domain.vo.in_warehouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grainoil.system.domain.vo.FileVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/17 17:27
 */
@Data
@ApiModel("入仓单明细视图")
public class InWarehouseDetailVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "入仓明细表id")
    private Long id;

    @ApiModelProperty(name = "inWarehouseId", value = "入仓通知单id")
    private Long inWarehouseId;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称")
    private String grainDepotName;

    @ApiModelProperty(name = "storehouseId", value = "仓房id")
    private Long storehouseId;

    @ApiModelProperty(name = "storehouseName", value = "仓房名称")
    private String storehouseName;

    @ApiModelProperty(name = "heapId", value = "堆位id")
    private Long heapId;

    @ApiModelProperty(name = "heapName", value = "堆位编码")
    private String heapName;

    @ApiModelProperty(name = "childHeapId", value = "子堆id")
    private Long childHeapId;

    @ApiModelProperty(name = "childHeapCode", value = "子堆编号")
    private String childHeapCode;

    @ApiModelProperty(name = "previousStock", value = "上次结余库存")
    private Double previousStock;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "warehouseDate", value = "入仓日期")
    private Date warehouseDate;

    @ApiModelProperty(name = "quantity", value = "当次入仓数量")
    private Double quantity;

    @ApiModelProperty(name = "numbers", value = "包数")
    private Long numbers;

    @JsonIgnore
    private String enclosure;

    @ApiModelProperty(name = "fileVos", value = "附件详情集合")
    private List<FileVo> fileVos;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "isAudit", value = "审核状态")
    private String isAudit;

    @ApiModelProperty(name = "name", value = "审核人")
    private String name;

}
