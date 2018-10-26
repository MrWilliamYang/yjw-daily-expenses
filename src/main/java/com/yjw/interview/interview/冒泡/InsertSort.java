package com.yjw.interview.interview.冒泡;

/**
 * 插入排序算法
 * 
 * 插入排序类似于打扑克牌，从第二张牌开始插入，小的插到大的前面，然后使其有序。
 * 再拿第三张牌来，找到合适的位置继续插入，使这三张有序。在第四张直至全部插入有序。举例说明：
 * 
 * @description InsertSort.java, 
 * @author YangJianWei
 * @date 2018年9月3日 下午5:16:50 
 * @version $Id: v 0.1
 */
public class InsertSort {

    public static void main(String[] args) {
        //定义一个数组
        int[] array = { 9, 7, 5, 3, 1, 2, 4, 6, 8, 10 };
        array = InsertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] InsertSort(int[] array) {
        int tmp = 0;
        int j;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
        return array;
    }
}
