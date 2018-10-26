package com.yjw.interview.interview.冒泡;

/**
 * 选择排序
 * 
 * 选择排序就是从第一趟开始，用第一个元素和剩下中的每一个元素比较，如果比第一个小，就和第一个元素交换值，
 * 最后使得第一个元素中的值最小，第二趟选择出第二小的放到第二元素，依次，使得数组有序。如同冒泡排序一般，
 * 第一个for循环控制趟数，第二个for循环控制每一趟中比较的次数。下面我们举例说明：
 * 
 * 
 * 
 * @description SelectSort.java, 
 * @author YangJianWei
 * @date 2018年9月3日 下午5:42:24 
 * @version $Id: v 0.1
 */
public class SelectSort {

    public static void main(String[] args) {
        //定义一个数组
        int[] array = { 9, 7, 5, 3, 1, 2, 4, 6, 8, 10 };
        array = SelectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] SelectSort(int[] array) {
        int tmp;
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    tmp = array[minIndex];
                    array[minIndex] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
