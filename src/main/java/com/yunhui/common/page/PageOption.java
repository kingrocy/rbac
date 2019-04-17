package com.yunhui.common.page;
import lombok.Setter;

@Setter
public class PageOption {

    protected Integer pageNo;
    protected Integer pageSize;
    protected Boolean pagination;
    protected Boolean queryCount;

    private static final int DEFAULT_PAGE=1;
    private static final int DEFAULT_PAGE_SIZE=10;


    public Integer getPageNo() {
        if(pageNo==null){
            return DEFAULT_PAGE;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if(pageSize==null){
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public int getOffset() {
        return getPageSize() * (getPageNo() - 1);
    }

    public Boolean getPagination() {
        if(pagination==null){
            return true;
        }
        return pagination;
    }


    public Boolean getQueryCount() {
        if(queryCount==null){
            return true;
        }
        return queryCount;
    }
}
