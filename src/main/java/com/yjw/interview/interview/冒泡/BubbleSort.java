package com.yjw.interview.interview.冒泡;

/**
 * 冒泡排序
 * 
 * 这里要说明的是这里有两个for循环嵌套，其中第一个for循环是控制比较的趟数（每一趟选出一个最大值），
 * 第二个for是比较的次数（比较相邻两个是中较大的值）。但这个冒泡排序是有缺憾的，是可以优化的。
 * 这里我们说一个简单的优化，如果原来的数组就是有序的，那这个排序还是会选择每一个比较，时间复杂度会很大，
 * 于是我们可以这么优化：在第二个for设计一个int类型标志flg定义为0，如果发生交换，那么flg++，如果flg结果为0，
 * 说明没有发生交换，那么数组本身就是有序的。函数如下:
 * 
 * @description BubbleSort.java, 
 * @author YangJianWei
 * @date 2018年9月3日 下午4:23:59 
 * @version $Id: v 0.1 
 */
public class BubbleSort {

    public static void main(String[] args) {
        //定义一个数组
        int[] array = { 9, 7, 5, 3, 1, 2, 4, 6, 8, 10 };
        BubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void BubbleSort(int[] array) {
        //        //遍历数组长度
        //        for (int i = 0; i < array.length - 1; i++) {
        //            for (int j = 0; j < array.length - 1 - i; j++) {
        //                if (array[j] > array[j + 1]) {
        //                    int temp = array[j];
        //                    array[j] = array[j + 1];
        //                    array[j + 1] = temp;
        //                }
        //            }
        //        }
        for (int i = 0; i < array.length - 1; i++) {
            int flg = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flg += 1;
                }
            }
            if (flg == 0) {
                break;
            }
        }
    }
}
