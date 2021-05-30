package com.grainoil.system.domain.vo.storage_contract;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/17 5:51
 */
@Data
@ApiModel(value = "StorageContractDetailedVo", description = "存储合同明细表修改与新增")
public class StorageContractDetailedVo implements Serializable {

    public static final long serialVersionUID = 1L;

//    @ApiModelProperty(name = "id", value = "明细表id")
//    private Long id;

    @JsonIgnore
    private Long stroageContractId;

    @ApiModelProperty(name = "grainDepotId", value = "粮库id", required = true)
    @NotNull(message = "粮库id不能为空")
    private Long grainDepotId;

    @ApiModelProperty(name = "grainDepotName", value = "粮库名称(添加时不需要)")
    private String grainDepotName;

    @ApiModelProperty(name = "varietyId", value = "粮食品种id", required = true)
    @NotNull(message = "粮油品种id不能为空")
    private Long varietyId;

    @ApiModelProperty(name = "variety", value = "粮油品种名称(添加时不需要)")
    private String variety;

    @JsonIgnore
    private Long grainRegionId;

    @JsonIgnore
    private String grainRegionName;

    @ApiModelProperty(name = "quantity", value = "存储数量", required = true)
    @NotNull(message = "存储数量不能为空")
    private Double quantity;

    @ApiModelProperty(name = "price", value = "核定成本,单位 元/吨", required = true)
    @NotNull(message = "核定成本不能为空")
    private Double price;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
