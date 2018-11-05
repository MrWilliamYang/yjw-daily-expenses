package com.yjw.expenses.common;

/**
 * 性别枚举类(包含以下方法)
 * 
 * 通过性别ID获取性别编码
 * 通过性别ID获取性别说明
 * 通过性别编码获取性别说明
 * 通过性别说明获取性别编码
 * 
 * @description GenderEnum.java
 * @author YangJianWei
 * @date 2018年10月8日 下午4:52:58
 * @version $Id: v 0.1 
 */
public enum GenderTypeEnum {
    
    MAN(1, "M", "男"), 
    WOMAN(2, "W", "女"), 
    MANTOWOMAN(3, "MW", "男性变女性"), 
    WOMANTOMAN(4, "WM", "女性变男性"), 
    UNKNOW(5, "U", "未知");

    /**
     * 性别ID
     */
    private Integer genderId;

    /**
     * 性别编码
     */
    private String  genderCode;

    /**
     * 性别说明
     */
    private String  genderDesc;

    private GenderTypeEnum(Integer genderId, String genderCode, String genderDesc) {
        this.genderId = genderId;
        this.genderCode = genderCode;
        this.genderDesc = genderDesc;
    }

    /**
     * 通过性别ID获取性别编码
     * 
     * @param genderId
     * @return
     */
    public static String getGenderCode(Integer genderId) {
        if (genderId < 1 || genderId == null) {
            return null;
        }
        for (GenderTypeEnum genderEnum : GenderTypeEnum.values()) {
            if (genderEnum.getGenderId().equals(genderId)) {
                return genderEnum.getGenderCode();
            }
        }
        return null;
    }

    /**
     * 通过性别ID获取性别说明
     * 
     * @param genderId
     * @return
     */
    public static String getGenderDesc(Integer genderId) {
        if (genderId < 1 || genderId == null) {
            return null;
        }
        for (GenderTypeEnum genderEnum : GenderTypeEnum.values()) {
            if (genderEnum.getGenderId().equals(genderId)) {
                return genderEnum.getGenderDesc();
            }
        }
        return null;
    }

    /**
     * 通过性别编码获取性别说明
     * 
     * @param genderCode
     * @return
     */
    public static String getGenderDesc(String genderCode) {
        if (genderCode.equals("") || genderCode == null) {
            return null;
        }
        for (GenderTypeEnum genderEnum : GenderTypeEnum.values()) {
            if (genderEnum.getGenderCode().equals(genderCode)) {
                return genderEnum.getGenderDesc();
            }
        }
        return null;
    }

    /**
     * 通过性别说明获取性别编码
     * 
     * @param genderDesc
     * @return
     */
    public static String getGenderCode(String genderDesc) {
        if (genderDesc.equals("") || genderDesc == null) {
            return null;
        }
        for (GenderTypeEnum genderEnum : GenderTypeEnum.values()) {
            if (genderEnum.getGenderDesc().equals(genderDesc)) {
                return genderEnum.getGenderCode();
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>genderId</tt>.
     * 
     * @return property value of genderId
     */
    public Integer getGenderId() {
        return genderId;
    }

    /**
     * Setter method for property <tt>genderId</tt>.
     * 
     * @param genderId value to be assigned to property genderId
     */
    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    /**
     * Getter method for property <tt>genderCode</tt>.
     * 
     * @return property value of genderCode
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * Setter method for property <tt>genderCode</tt>.
     * 
     * @param genderCode value to be assigned to property genderCode
     */
    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    /**
     * Getter method for property <tt>genderDesc</tt>.
     * 
     * @return property value of genderDesc
     */
    public String getGenderDesc() {
        return genderDesc;
    }

    /**
     * Setter method for property <tt>genderDesc</tt>.
     * 
     * @param genderDesc value to be assigned to property genderDesc
     */
    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    public static void main(String[] args) {
        Integer genderId1 = 1;
        Integer genderId2 = 3;
        Integer genderId3 = 5;
        String GenderCode1 = GenderTypeEnum.getGenderCode(genderId1);
        System.out.println(GenderCode1);
        String GenderCode2 = GenderTypeEnum.getGenderCode(genderId2);
        System.out.println(GenderCode2);
        String GenderCode3 = GenderTypeEnum.getGenderCode(genderId3);
        System.out.println(GenderCode3);
        String GenderDesc1 = GenderTypeEnum.getGenderDesc(genderId1);
        System.out.println(GenderDesc1);
        String GenderDesc2 = GenderTypeEnum.getGenderDesc(genderId2);
        System.out.println(GenderDesc2);
        String GenderDesc3 = GenderTypeEnum.getGenderDesc(genderId3);
        System.out.println(GenderDesc3);

        String genderCode1 = "M";
        String genderCode2 = "W";
        String genderCode3 = "WM";
        String GenderDesc11 = GenderTypeEnum.getGenderDesc(genderCode1);
        System.out.println(GenderDesc11);
        String GenderDesc22 = GenderTypeEnum.getGenderDesc(genderCode2);
        System.out.println(GenderDesc22);
        String GenderDesc33 = GenderTypeEnum.getGenderDesc(genderCode3);
        System.out.println(GenderDesc33);

        String genderDesc1 = "女";
        String genderDesc2 = "女性变男性";
        String genderDesc3 = "未知";
        String GenderCode11 = GenderTypeEnum.getGenderCode(genderDesc1);
        System.out.println(GenderCode11);
        String GenderCode22 = GenderTypeEnum.getGenderCode(genderDesc2);
        System.out.println(GenderCode22);
        String GenderCode33 = GenderTypeEnum.getGenderCode(genderDesc3);
        System.out.println(GenderCode33);

    }
}
