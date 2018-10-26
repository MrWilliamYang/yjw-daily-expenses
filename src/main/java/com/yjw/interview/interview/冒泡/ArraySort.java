package com.yjw.interview.interview.冒泡;

import java.util.Arrays;

/**
 * 利用Arrays带有的排序方法快速排序
 * 
 * @description ArraySort.java, 
 * @author YangJianWei
 * @date 2018年9月3日 下午4:45:04 
 * @version $Id: v 0.1 
 */
public class ArraySort {

    public static void main(String[] args) {
        //定义一个数组
        int[] nums = { 9, 7, 5, 3, 1, 2, 4, 6, 8, 10 };
        //排序
        Arrays.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
