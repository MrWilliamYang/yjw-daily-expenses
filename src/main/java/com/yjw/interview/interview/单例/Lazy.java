package com.yjw.interview.interview.单例;

/**
 * 懒汉模式（线程不安全、懒加载）
 * 
 * 实例变量的hashCode值不一致，说明对象不是同一个，懒汉式单例实现是非线程安全的。
 * 优点是实现了懒加载思想。
 * 
 * @description Lazy.java
 * @author YangJianWei
 * @date 2018年8月27日 下午1:57:56
 * @version $Id:  v 0.1 
 */
public class Lazy {

    private Lazy() {

    }

    private volatile static Lazy singleton = null;

    public static Lazy getSingleton() {
        if (singleton == null) {
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            singleton = new Lazy();
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Lazy.getSingleton());
                }
            }).start();
        }
    }
}
