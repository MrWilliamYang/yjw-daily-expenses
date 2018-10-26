package com.yjw.interview.common;
/**
 * 错误码对照表
 * 
 * @description RespHeaderErrorEnum.java,
 * @author YangJianWei
 * @date 2018年10月9日 下午3:59:01
 * @version $Id: v 0.1 
 */
public enum ResponseErrorEnum {
    
    GENERAL_ERROR("-1","通用错误"),
    SYSYTEM_UNKNOW("900000", "系统未知错误"),
    DATE_ADD_WRONG("900201", "数据添加失败"),
    PARAM_CHECK_FAILD("900101", "参数校验失败"),
    DATA_NOT_EXIST("900200", "数据不存在"),
    FEIGN_FAIL("900102","Feign服务调用异常"),
    CRED_IS_WRONG("420101","身份证信息错误"),
    NAME_IS_WRONG("420102","姓名信息错误"),
    CARD_BINDING_PHONE_ERROR("620102","目前不支持此手机号码号段");
    
    String errorCode;
    String errorMessage;

    /**
     * @param errorCode
     * @param errorMessage
     */
    private ResponseErrorEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
