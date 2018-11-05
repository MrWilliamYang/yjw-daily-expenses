package com.yjw.expenses.pojo.entity;

import java.util.List;

/**
 * 
 * @author YangJianWei
 * @version $Id: PageEntity.java, v 0.1 2018年6月20日 下午1:41:29 YangJianWei Exp $
 */
public class PageEntity {

    /**
     * 分页ID
     */
    private int     id;

    /**
     * 当前页码
     */
    private int     page;

    /**
     * 每页显示数据
     */
    private int     pageRow;

    /**
     * 总条数
     */
    private int     totalNum;

    /**
     * 总页码
     */
    private int     totalPage;

    /**
     * 页面数据集合
     */
    private List<?> list;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>page</tt>.
     * 
     * @return property value of page
     */
    public int getPage() {
        return page;
    }

    /**
     * Setter method for property <tt>page</tt>.
     * 
     * @param page value to be assigned to property page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Getter method for property <tt>pageRow</tt>.
     * 
     * @return property value of pageRow
     */
    public int getPageRow() {
        return pageRow;
    }

    /**
     * Setter method for property <tt>pageRow</tt>.
     * 
     * @param pageRow value to be assigned to property pageRow
     */
    public void setPageRow(int pageRow) {
        this.pageRow = pageRow;
    }

    /**
     * Getter method for property <tt>totalNum</tt>.
     * 
     * @return property value of totalNum
     */
    public int getTotalNum() {
        return totalNum;
    }

    /**
     * Setter method for property <tt>totalNum</tt>.
     * 
     * @param totalNum value to be assigned to property totalNum
     */
    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * Getter method for property <tt>totalPage</tt>.
     * 
     * @return property value of totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * Setter method for property <tt>totalPage</tt>.
     * 
     * @param totalPage value to be assigned to property totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<?> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<?> list) {
        this.list = list;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PageEntity [id=" + id + ", page=" + page + ", pageRow=" + pageRow + ", totalNum="
               + totalNum + ", totalPage=" + totalPage + ", list=" + list + "]";
    }

}
