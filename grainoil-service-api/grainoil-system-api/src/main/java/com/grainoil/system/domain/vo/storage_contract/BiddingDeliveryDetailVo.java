package com.grainoil.system.domain.vo.storage_contract;

import com.grainoil.system.domain.vo.FileVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 14:45
 */
@Data
public class BiddingDeliveryDetailVo {

    /**
     * （合计）存储数量
     */
    @ApiModelProperty(name = "quantity",value = "出库数量")
    private Double quantity;

    /**
     * 存储附件
     */
    @ApiModelProperty(name = "contractFile",value = "存储文件")
    private FileVo contractFile;

    /**
     * 存储企业id
     */
    @ApiModelProperty(name = "organizeId",value = "存储企业id")
    private Long organizeId;

    /**
     * 存储企业
     */
    @ApiModelProperty(name = "organizeName",value = "存储企业")
    private String organizeName;

    /**
     * 承储合同id
     */
    @ApiModelProperty(name = "storageContractId",value = "承储合同id")
    private Long storageContractId;

    /**
     * 承储合同编号
     */
    @ApiModelProperty(name = "storageContractCode",value = "承储合同编号")
    private String storageContractCode;

    /**
     * 批文编号
     */
    @ApiModelProperty(name = "contractCode",value = "批文编号")
    private String contractCode;

    /**
     * 批文名称
     */
    @ApiModelProperty(name = "contractName",value = "批文名称")
    private String contractName;

    /**
     * 批文附件
     */
    @ApiModelProperty(name = "file",value = "批文附件")
    private FileVo file;

    /**
     * 出库开始时间
     */
    @ApiModelProperty(name = "beginDate",value = "出库开始时间")
    private Date beginDate;

    /**
     * 出库结束时间
     */
    @ApiModelProperty(name = "endDate",value = "出库结束时间")
    private Date endDate;

}
