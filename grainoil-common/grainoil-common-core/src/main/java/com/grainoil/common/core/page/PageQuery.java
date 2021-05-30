package com.grainoil.common.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: chenminghong
 * @Date: 2021/5/17 18:16
 */
@Data
@ApiModel(description = "分页")
public class PageQuery {

    @ApiModelProperty("每页条数")
    private int pageSize;

    @ApiModelProperty("当前页码")
    private int current;

    public PageQuery() {
        this.pageSize = 10;
        this.current = 1;
    }
}
