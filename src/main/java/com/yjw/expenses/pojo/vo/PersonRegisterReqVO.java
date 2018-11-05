/**
 * hxgy Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yjw.expenses.pojo.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 人物注册 Request
 * 
 * @author YangJianWei
 * @version $Id: InsertPersonVO.java, v 0.1 2018年10月9日 下午2:14:00 YangJianWei Exp $
 */
public class PersonRegisterReqVO {

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;

    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空")
    private String  tel;

    /**
     * 姓名（登录名）
     */
    @NotBlank(message = "姓名不能为空")
    private String  name;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String  password;

    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String  avatar;

    /**
     * Getter method for property <tt>gender</tt>.
     * 
     * @return property value of gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * Setter method for property <tt>gender</tt>.
     * 
     * @param gender value to be assigned to property gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * Getter method for property <tt>age</tt>.
     * 
     * @return property value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>tel</tt>.
     * 
     * @return property value of tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Setter method for property <tt>tel</tt>.
     * 
     * @param tel value to be assigned to property tel
     */
    public void setTel(String tel) {
        this.tel = tel;
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
     * Getter method for property <tt>password</tt>.
     * 
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     * 
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>avatar</tt>.
     * 
     * @return property value of avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Setter method for property <tt>avatar</tt>.
     * 
     * @param avatar value to be assigned to property avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PersonRegisterVO [gender=" + gender + ", age=" + age + ", tel=" + tel + ", name="
               + name + ", password=" + password + ", avatar=" + avatar + "]";
    }

}
