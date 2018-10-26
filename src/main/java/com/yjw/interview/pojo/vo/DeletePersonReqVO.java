package com.yjw.interview.pojo.vo;

import javax.validation.constraints.NotNull;

/**
 * 删除用户 Request
 * 
 * @description DeletePersonReqVO.java
 * @author YangJianWei
 * @date 2018年10月26日 下午1:59:25
 * @version $Id: v 0.1 
 */
public class DeletePersonReqVO {

    /**
     * 用户 id
     */
    @NotNull(message = "用户id不能为空")
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
        return "DeletePersonReqVO [id=" + id + "]";
    }

}
