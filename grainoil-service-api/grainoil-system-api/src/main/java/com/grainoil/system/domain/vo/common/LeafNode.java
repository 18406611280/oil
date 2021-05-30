package com.grainoil.system.domain.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author song
 * @date create in 21/5/19 14:00
 */
@Data
@ApiModel("叶子节点")
public class LeafNode implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "value", value = "value值")
    private String value;

    @ApiModelProperty(name = "label", value = "标签值")
    private String label;

}
