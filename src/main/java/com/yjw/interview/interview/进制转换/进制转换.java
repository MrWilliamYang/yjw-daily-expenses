/**
 * hxgy Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yjw.interview.interview.进制转换;

import java.util.Scanner;

/**
 * 进制转换
 * 
 * @description 进制转换.java, 
 * @author YangJianWei
 * @date 2018年9月17日 上午9:36:31 
 * @version $Id: v 0.1
 */
public class 进制转换 {

    public static void main(String[] args) {
        int num = 0;
        //获取系统输入
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个十进制的整数");
        num = scan.nextInt();

        String str_bin = toBinary(num);
        String str_oct = toOctal(num);
        String str_hex = toHex(num);

        System.out.println("bin = " + str_bin);
        System.out.println("oct = " + str_oct);
        System.out.println("hex = " + str_hex);
    }

    //十进制转二进制
    public static String toBinary(int num) {
        return trans(num, 1, 1);
    }

    //十进制转八进制
    private static String toOctal(int num) {
        return "0" + trans(num, 7, 3);
    }

    //十进制转十六进制
    public static String toHex(int num) {
        return "0x" + trans(num, 15, 4);
    }

    //用于进制转换的功能.
    public static String trans(int num, int base, int offset) {
        if (num == 0)
            return "0";
        //建表.
        char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                       'F' };
        //创建临时容器。
        char[] arr = new char[8];
        int index = arr.length;
        while (num != 0) {
            int temp = num & base;
            arr[--index] = chs[temp];
            num = num >>> offset;
        }
        return toString(arr, index);
    }

    //定义一个功能，将字符数组转成字符串.
    private static String toString(char[] arr, int index) {
        String temp = "";
        for (int x = index; x < arr.length; x++) {
            temp = temp + arr[x];
        }
        return temp;
    }

}
