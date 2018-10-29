package com.yjw.interview.pojo.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加日常开销 Request
 * 
 * @description ExpensesReqVO.java
 * @author YangJianWei
 * @date 2018年10月12日 上午9:25:33
 * @version $Id: v 0.1 
 */
public class ExpensesReqVO {

    /**
     * personid
     */
    @NotNull(message = "账号异常")
    private Integer personId;

    /**
     * 物品名称
     */
    @NotBlank(message = "物品名称不能为空")
    private String  name;

    /**
     * 数量
     */
    @NotBlank(message = "数量不能为空")
    private String  quantity;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    private String  price;

    /**
     * 金额（数量×单价）
     */
    @NotNull(message = "金额不能为空")
    private String  amount;

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
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>quantity</tt>.
     * 
     * @return property value of quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Setter method for property <tt>quantity</tt>.
     * 
     * @param quantity value to be assigned to property quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter method for property <tt>price</tt>.
     * 
     * @return property value of price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Setter method for property <tt>price</tt>.
     * 
     * @param price value to be assigned to property price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ExpensesReqVO [personId=" + personId + ", name=" + name + ", quantity=" + quantity
               + ", price=" + price + ", amount=" + amount + "]";
    }

}
