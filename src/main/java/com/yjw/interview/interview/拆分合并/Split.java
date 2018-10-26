package com.yjw.interview.interview.拆分合并;

/**
 * 字符串拆分
 * 
 * @description Split.java, 
 * @author YangJianWei
 * @date 2018年9月6日 下午5:56:58 
 * @version $Id: v 0.1
 */
public class Split {

    public static void main(String[] args) {
        String provinceName = "BEIJING-北京";

        String str[] = provinceName.split("-");//根据-拆分
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);//根据下标i取需要得到的值
        }
    }
}
