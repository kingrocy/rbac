package com.yunhui.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult<T> {

    private Integer pageNo;

    private Integer pageSize;

    private Integer totalCount;

    private List<T> data;


}