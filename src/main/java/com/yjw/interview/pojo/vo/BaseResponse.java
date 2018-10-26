package com.yjw.interview.pojo.vo;

import com.yjw.interview.common.ResponseErrorEnum;

/**
 * 统一返回参数
 * 
 * @author YangJianWei
 * @version $Id: BaseResponse.java, v 0.1 2018年10月9日 下午2:11:43 YangJianWei Exp $
 */
public class BaseResponse {

    private String             code;               //00 成功 其他操作对照码

    private String             msg;

    private Object             data;

    public static final String SUCCESS_CODE = "00";

    public static BaseResponse success(String msg) {
        BaseResponse res = new BaseResponse();
        res.setCode(SUCCESS_CODE);
        res.setMsg(msg);
        return res;
    }

    public static BaseResponse success() {
        return success("操作成功");
    }

    public static BaseResponse success(Object data) {
        BaseResponse resp = success();
        resp.setData(data);
        return resp;
    }

    public static BaseResponse error(String code, String message) {
        BaseResponse res = new BaseResponse();
        res.setCode(code);
        res.setMsg(message);
        return res;
    }

    public static BaseResponse error(ResponseErrorEnum error) {
        BaseResponse res = new BaseResponse();
        res.setCode(error.getErrorCode());
        res.setMsg(error.getErrorMessage());
        return res;
    }

    public static BaseResponse error(String errorMsg) {
        BaseResponse res = new BaseResponse();
        res.setCode(ResponseErrorEnum.GENERAL_ERROR.getErrorCode());
        res.setMsg(errorMsg);
        return res;
    }

    public static BaseResponse error(ResponseErrorEnum error, String extraMsg) {
        BaseResponse res = new BaseResponse();
        res.setCode(error.getErrorCode());
        res.setMsg(error.getErrorMessage() + " : " + extraMsg);
        return res;
    }

    public static BaseResponse paramError(String extraMsg) {
        BaseResponse res = new BaseResponse();
        res.setCode(ResponseErrorEnum.PARAM_CHECK_FAILD.getErrorCode());
        res.setMsg(extraMsg);
        return res;
    }

    public static BaseResponse code(ResponseErrorEnum error) {
        BaseResponse res = new BaseResponse();
        res.setCode(error.getErrorCode());
        return res;
    }

    public BaseResponse msg(String msg) {
        this.msg = msg;
        return this;
    }

    public BaseResponse data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     * @param msg value to be assigned to property msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>data</tt>.
     * @return property value of data
     */
    public Object getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     * @param data value to be assigned to property data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /** 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "BaseResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}
