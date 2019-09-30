package org.dfzr.vo;

import java.util.List;

/**
 * 用于存放分页信息
 */
public class PageVo<T> {
    //总页数
    private Integer totalPage;
    //当前页
    private Integer currentPage;
    //总条数
    private Integer totalCount;
    //当前查询的结果
    private List<T> objects;

    @Override
    public String toString() {
        return "PageVo{" +
                "totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", objects=" + objects +
                '}';
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
