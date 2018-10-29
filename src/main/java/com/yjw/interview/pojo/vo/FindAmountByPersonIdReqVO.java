package com.yjw.interview.pojo.vo;

import javax.validation.constraints.NotNull;

/**
 * 根据用户id查询花销合计
 * 
 * @description FindAmountByPersonIdReqVO.java
 * @author YangJianWei
 * @date 2018年10月29日 下午5:17:36
 * @version $Id: v 0.1 
 */
public class FindAmountByPersonIdReqVO {

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
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
        return "FindAmountByPersonIdReqVO [personId=" + personId + "]";
    }

}
