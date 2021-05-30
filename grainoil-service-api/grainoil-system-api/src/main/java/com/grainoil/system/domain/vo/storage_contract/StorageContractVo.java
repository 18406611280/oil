package com.grainoil.system.domain.vo.storage_contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grainoil.system.domain.vo.FileVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/17 5:47
 */
@Data
@ApiModel(value = "StorageContractVo", description = "存储合同新增与修改")
public class StorageContractVo implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "存储合同id(添加存储合同时不需要)")
    private Long id;

    @ApiModelProperty(name = "contractCode", value = "合同编号", required = true)
    @NotBlank(message = "合同编号不能为空")
    private String contractCode;

    @ApiModelProperty(name = "organizeId", value = "承储企业id", required = true)
    @NotNull(message = "承储企业id不能为空")
    private Long organizeId;

    @ApiModelProperty(name = "organizeName", value = "承储企业(添加时不需要)")
    private String organizeName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "beginDate", value = "承储周期开始(yyyy-MM-dd)", required = true)
    @NotNull(message = "承储周期开始时间不能为空")
    private Date beginDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "endDate", value = "承储周期结束(yyyy-MM-dd)", required = true)
    @NotNull(message = "承储周期结束时间不能为空")
    private Date endDate;

    @ApiModelProperty(name = "contractFileId", value = "合同附件id", required = true)
    @NotNull(message = "合同附件id不能为空")
    private Long contractFileId;

    @ApiModelProperty(name = "fileVo", value = "合同附件信息(添加时不需要)")
    private FileVo fileVo;

    @JsonIgnore
    private Long grainOwnerId;

    @JsonIgnore
    private String grainOwnerName;

    @ApiModelProperty(name = "detailedList", value = "合同明细", required = true)
    @NotEmpty(message = "合同明细至少需要一条数据")
    private List<StorageContractDetailedVo> detailedList;
}
