package com.springboot.dubbo.demo.common.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Benson on 2018/3/28.
 */
public class PageDto extends Dto {

    @ApiModelProperty(value = "页码，默认第一页", name = "pageNumber", required = true)
    protected Integer pageNumber = PAGE_NUMBER;
    @ApiModelProperty(value = "每页行数，默认每页10行", name = "pageSize", required = true)
    protected Integer pageSize = PAGE_SIZE;

    public Integer getPageNumber() {
        return pageNumber == null || pageNumber <= 0 ? PAGE_NUMBER : pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize == null || pageSize <= 0 ? PAGE_SIZE : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
