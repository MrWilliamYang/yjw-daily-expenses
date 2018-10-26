package com.yjw.interview.common;


//import org.apache.commons.lang3.StringUtils;

/**
 * 证件类型枚举
 * 
 * @description CredTypeEnum.java
 * @author YangJianWei
 * @date 2018年7月30日 下午5:56:45
 * @version $Id: , v 0.1
 */
public enum CredTypeEnum {

    IDCARD(1,"01","身份证"),
    MILITARYOFFICERCARD(2,"02","军官证"),
    OTHERCARD(3,"03","其他"),
    JFJWZGBZ(4,"04","解放军文职干部证"),
    POLICEOFFICERCARD(5,"05","警官证"),
    JFJSBZ(6,"06","解放军士兵证"),
    HUKOU(7,"07","户口薄"),
    GAHXTXZ(8,"08","港澳回乡证通行证"),
    TWJQTYXLXZ(9,"09","台通行证及其他有效旅行证"),
    FOREIGNPASSPORT(10,"10","外国护照"),
    CHINESEPASSPORT(11,"11","中国护照"),
    WJWZGBZ(12,"12","武警文职干部证"),
    WJSBZ(13,"13","武警士兵证"),
    QGZZJGDM(14,"14","全国组织机构代码"),
    BIRTHCARD(15,"15","出生证"),
    UNKONW(null,null,"未知证件"),;

    /**
     * 证件类型id
     */
    private Integer documentTypeID;

    /**
     * 证件类型编码
     */
    private String  documentTypeCode;

    /**
     * 证件类型说明
     */
    private String  documentTypeDesc;

//    public static CredTypeEnum getByDocumentTypeCode(String documentTypeCode) {
//        if (StringUtils.isEmpty(documentTypeCode)) {
//            return CredTypeEnum.UNKONW;
//        }
//        for (CredTypeEnum credTypeEnum : CredTypeEnum.values()) {
//            if (documentTypeCode.equals(credTypeEnum.getDocumentTypeCode())) {
//                return credTypeEnum;
//            }
//        }
//        return CredTypeEnum.UNKONW;
//    }

    private CredTypeEnum(Integer documentTypeID, String documentTypeCode, String documentTypeDesc) {
        this.documentTypeID = documentTypeID;
        this.documentTypeCode = documentTypeCode;
        this.documentTypeDesc = documentTypeDesc;
    }

    /**
     * Getter method for property <tt>documentTypeID</tt>.
     * 
     * @return property value of documentTypeID
     */
    public Integer getDocumentTypeID() {
        return documentTypeID;
    }

    /**
     * Setter method for property <tt>documentTypeID</tt>.
     * 
     * @param documentTypeID value to be assigned to property documentTypeID
     */
    public void setDocumentTypeID(Integer documentTypeID) {
        this.documentTypeID = documentTypeID;
    }

    /**
     * Getter method for property <tt>documentTypeCode</tt>.
     * 
     * @return property value of documentTypeCode
     */
    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    /**
     * Setter method for property <tt>documentTypeCode</tt>.
     * 
     * @param documentTypeCode value to be assigned to property documentTypeCode
     */
    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    /**
     * Getter method for property <tt>documentTypeDesc</tt>.
     * 
     * @return property value of documentTypeDesc
     */
    public String getDocumentTypeDesc() {
        return documentTypeDesc;
    }

    /**
     * Setter method for property <tt>documentTypeDesc</tt>.
     * 
     * @param documentTypeDesc value to be assigned to property documentTypeDesc
     */
    public void setDocumentTypeDesc(String documentTypeDesc) {
        this.documentTypeDesc = documentTypeDesc;
    }

}
