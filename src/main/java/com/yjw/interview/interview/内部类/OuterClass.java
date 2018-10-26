package com.yjw.interview.interview.内部类;

/**
 * 内部类实现
 * 
 * @description OuterClass.java, 
 * @author YangJianWei
 * @date 2018年9月3日 上午9:37:47 
 * @version $Id: v 0.1
 */
public class OuterClass {

    private class InterClass {
        public InterClass() {
            System.out.println("InterClass Create");
        }
    }

    public OuterClass() {
        @SuppressWarnings("unused")
        InterClass ic = new InterClass();
        System.out.println("OuterClass Create");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        OuterClass oc = new OuterClass();
    }

}
