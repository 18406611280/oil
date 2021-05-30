package com.grainoil.common.core.page;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/17 18:24
 */
@Data
@ApiModel(description = "分页返回信息")
public class PageView<T> {

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数")
    private Long total;

    /**
     * 结果集
     */
    @ApiModelProperty(value = "结果集")
    private List<T> list;

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码")
    private int pageNum;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量")
    private int pageSize;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private int pages;

    public PageView() {
    }

    public PageView(PageInfo<T> pageInfo) {
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
    }
}
