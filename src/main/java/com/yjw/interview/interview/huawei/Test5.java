package com.yjw.interview.interview.huawei;

/**
 * 
 * 按要求打印出一下图形
 * 
 *  ****
 *  ***
 *  **
 *  *
 * 
 * @description Test5.java, 
 * @author YangJianWei
 * @date 2018年8月28日 下午2:39:18 
 * @version $Id: v 0.1 
 */
public class Test5 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
