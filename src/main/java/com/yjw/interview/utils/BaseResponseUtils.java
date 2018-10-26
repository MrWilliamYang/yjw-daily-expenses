package com.yjw.interview.utils;

/**
 * 统一返回参数工具类
 * 
 * @description BaseResponseUtils.java, 
 * @author YangJianWei
 * @date 2018年8月31日 下午1:53:22 
 * @version $Id: v 0.1 
 */
public class BaseResponseUtils {

    /**
     * 返回 - 操作码
     */
    private String             code;               //0 - 返回成功，其他操作码对照

    /**
     * 返回 - 信息
     */
    private String             msg;

    /**
     * 返回 - 数据
     */
    private Object             data;

    public static final String SUCCESS_CODE = "00";

    public static BaseResponseUtils success(String msg) {
        BaseResponseUtils res = new BaseResponseUtils();
        res.setCode(SUCCESS_CODE);
        res.setMsg(msg);
        return res;
    }

    public static BaseResponseUtils success() {
        return success("操作成功");
    }

    public static BaseResponseUtils success(Object data) {
        BaseResponseUtils resp = success();
        resp.setData(data);
        return resp;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * 
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     * 
     * @param msg value to be assigned to property msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>data</tt>.
     * 
     * @return property value of data
     */
    public Object getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     * 
     * @param data value to be assigned to property data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BaseResponseUtils [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}
