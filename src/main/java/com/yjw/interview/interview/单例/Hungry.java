package com.yjw.interview.interview.单例;

/**
 * 饿汉式（线程安全、没有懒加载）
 * 
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题，实例变量的hashCode值一致，
 * 说明对象是同一个，饿汉式单例实现是线程安全的。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果，类加载的时候就会直接new 一个静态对象出来  
 * 如果从始至终从未使用过这个实例，则会造成内存的浪费。
 * 
 * @description Hungry.java
 * @author YangJianWei
 * @date 2018年8月24日 下午5:34:25
 * @version $Id: v 0.1 
 */
public class Hungry {

    private Hungry() {

    }

    private volatile static Hungry singleton = new Hungry();

    public static Hungry getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Hungry.getSingleton());
                }
            }).start();
        }
    }
}
