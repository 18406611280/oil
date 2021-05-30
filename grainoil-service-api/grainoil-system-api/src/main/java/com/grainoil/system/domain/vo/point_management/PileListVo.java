package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @Description
 * @date create in 21/5/14 10:29
 */
@ApiModel(value = "PileListVo", description = "堆位列表")
@Data
public class PileListVo implements Serializable {

    private static final long   serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "堆位id")
    private Long id;

    @ApiModelProperty(name = "pileCode", value = "堆位编码")
    private String pileCode;

//    @ApiModelProperty(name = "pileState", value = "堆位状态")
//    private String pileState;

    @ApiModelProperty(name = "packMethod", value = "包装方式")
    private String packMethod;

    @ApiModelProperty(name = "type", value = "1表示主堆, 0表示子堆")
    private String type;

    @ApiModelProperty(name = "isSplit", value = "是否已分堆, 1表示已分堆, 0表示未分堆")
    private String isSplit;
}
