package com.yjw.interview.interview.huawei;

import java.util.Calendar;

/**
 * 
 * 打印昨天的当前时刻
 * 
 * @description YesterdayCurrent.java, 
 * @author YangJianWei
 * @date 2018年8月28日 下午2:46:15 
 * @version $Id: v 0.1 
 */
public class YesterdayCurrent {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
    }
}
