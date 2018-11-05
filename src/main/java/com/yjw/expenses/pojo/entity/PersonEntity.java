package com.yjw.expenses.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 人物实体类
 * 
 * @author YangJianWei
 * @version $Id: PersonEntity.java, v 0.1 2018年10月9日 上午11:51:38 YangJianWei Exp $
 */
@Entity
@Table(name = "person")
public class PersonEntity {

    /**
     * 主键ID
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 电话
     */
    @Column(name = "tel")
    private String  tel;

    /**
     * 姓名（登录名）
     */
    @Column(name = "name")
    private String  name;

    /**
     * 密码
     */
    @Column(name = "password")
    private String  password;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String  avatar;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    updateTime;

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
     * Getter method for property <tt>createTime</tt>.
     * 
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     * 
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>updateTime</tt>.
     * 
     * @return property value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Setter method for property <tt>updateTime</tt>.
     * 
     * @param updateTime value to be assigned to property updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PersonEntity [id=" + id + ", gender=" + gender + ", age=" + age + ", tel=" + tel
               + ", name=" + name + ", password=" + password + ", avatar=" + avatar
               + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }

}
