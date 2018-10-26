package com.yjw.interview.interview.huawei;

/**
 * 请看题写出控制台输出内容
 * 
 * 输出结果：1234
 * 这里虽然是一个静态方法，但是里面的变量是一个局部变量，
 * 所以这里不因为是静态方法，就误认为里面的变量也是静态变量了
 * 
 * @author 总统
 * @version $Id: Test1.java, v 0.1 2018年5月28日 下午2:00:51 总统 Exp $
 */
public class Test1 {
    
    public static void changeStr(String str){
        str="welcome";
    }
    
    public static void main(String[] args) {
        String str="1234";
        changeStr(str);
        System.out.println(str);
    }
}
