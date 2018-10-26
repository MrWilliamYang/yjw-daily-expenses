package com.yjw.interview.interview.日期转换;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化
 * 
 * 日期格式转换为字符串格式
 * 字符串格式转换为日期格式
 * 
 * @description SimpleDateFormat.java, 
 * @author YangJianWei
 * @date 2018年9月3日 上午11:50:26 
 * @version $Id: v 0.1
 */
public class DateFormat {

    public static void main(String[] args) {

        /**
         * 日期格式转换为字符串格式
         */
        //获取当前时间
        Date date = new Date();
        //打印当前时间
        System.out.println(date);
        //打印date数据类型
        System.out.println(date.getClass().getName());
        //设置日期时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   HH时mm分ss秒  ");
        //将Date类型转换成String类型
        String format = sdf.format(date);
        //打印当前时间
        System.out.println(format);
        //打印format数据类型
        System.out.println(format.getClass().getName());

        System.out.println("**********************一条美丽的分割线*************************");

        /**
         * 字符串格式转换为日期格式
         */
        //定义一个字符串格式的时间
        String time = "2018-09-03 15:35:24";
        //打印String
        System.out.println(time);
        //打印String格式
        System.out.println(time.getClass().getName());
        //转换格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //转换为日期格式
            Date date1 = sdf1.parse(time);
            //打印日期
            System.out.println(date1);
            //打印日期格式
            System.out.println(date1.getClass().getName());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
