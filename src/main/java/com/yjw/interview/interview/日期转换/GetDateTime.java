package com.yjw.interview.interview.日期转换;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取系统当前年月日，时分秒，星期几
 * 
 * @description GetDateTime.java, 
 * @author YangJianWei
 * @date 2018年9月3日 上午10:04:04 
 * @version $Id: v 0.1 
 */
public class GetDateTime {

    public static void main(String[] args) {
        //设置时间日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   HH时mm分ss秒  ");
        //获取当前时间
        Date date = new Date();
        //计算星期几
        String weekDays = getWeekOfDate(date);
        //打印输出到控制台
        System.out.println(sdf.format(date) + weekDays);
    }

    /**
     * 由当前时间计算星期几
     * 
     * @param date
     * @return
     */
    private static String getWeekOfDate(Date date) {
        //注意，这里是外国计算周期，每周第一天是周日
        String[] weekDays = { "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

}
