package com.yjw.expenses.pojo.vo;

import javax.validation.constraints.NotNull;

/**
 * 删除花销 Request
 * 
 * @description DeleteExpensesReqVO.java
 * @author YangJianWei
 * @date 2018年10月27日 下午6:34:35
 * @version $Id: v 0.1 
 */
public class DeleteExpensesReqVO {

    /**
     * 花销id
     */
    @NotNull(message = "花销id不能为空")
    private Integer id;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DeleteExpensesReqVO [id=" + id + "]";
    }

}
