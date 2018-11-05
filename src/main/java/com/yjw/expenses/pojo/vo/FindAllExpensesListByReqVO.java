package com.yjw.expenses.pojo.vo;

import javax.validation.constraints.NotNull;

/**
 * 根据购买人查询花销列表
 * 
 * @description FindAllExpensesListByReqVO.java
 * @author YangJianWei
 * @date 2018年10月12日 下午5:41:39
 * @version $Id: v 0.1 
 */
public class FindAllExpensesListByReqVO {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Integer personId;

    /**
     * Getter method for property <tt>personId</tt>.
     * 
     * @return property value of personId
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * Setter method for property <tt>personId</tt>.
     * 
     * @param personId value to be assigned to property personId
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FindAllExpensesListByReqVO [personId=" + personId + "]";
    }

}
