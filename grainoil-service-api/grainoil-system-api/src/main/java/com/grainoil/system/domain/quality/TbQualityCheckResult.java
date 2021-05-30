package com.grainoil.system.domain.quality;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TbQualityCheckResult {
    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    /**
     * 样品详情id
     */
    @ApiModelProperty(name = "qualityApplyDetailedId",value = "样品详情id")
    private Long qualityApplyDetailedId;

    /**
     * 质检项id
     */
    @ApiModelProperty(name = "qualityCheckId",value = "质检项id")
    private Long qualityCheckId;

    /**
     * 质检项结果
     */
    @ApiModelProperty(name = "qualityCheckResult",value = "质检项结果")
    private String qualityCheckResult;
}