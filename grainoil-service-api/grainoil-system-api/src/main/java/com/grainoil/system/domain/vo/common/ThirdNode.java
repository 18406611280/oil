package com.grainoil.system.domain.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author song
 * @date create in 21/5/19 14:09
 */
@Data
@ApiModel("三级联动")
public class ThirdNode implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "value", value = "value值")
    private String value;

    @ApiModelProperty(name = "label", value = "标签值")
    private String label;

    @ApiModelProperty(name = "children", value = "联动下拉列表")
    private List<SecondNode> children;
}
