package com.yjw.interview.pojo.vo;

import javax.validation.constraints.NotNull;

/**
 * 根据用户id查询用户详情
 * 
 * @author YangJianWei
 * @version $Id: FindPersonsReqVO.java, v 0.1 2018年10月11日 下午4:44:28 YangJianWei Exp $
 */
public class FindPersonInfoReqVO {

    /**
     * 用户id
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
        return "FindPersonsReqVO [id=" + id + "]";
    }

}
