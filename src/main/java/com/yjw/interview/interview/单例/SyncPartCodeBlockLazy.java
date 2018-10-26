package com.yjw.interview.interview.单例;

/**
 * 懒汉模式（线程不安全、  效率高）
 * 
 * 实例变量的hashCode值不一致，说明对象不是同一个，使用synchronized关键字修饰局部代码块的懒汉式单例实现是非线程安全的。
 * 虽然这种实现方法相较于第三种和第四种方式效率要高一些，但并非线程安全的。
 * 
 * @description SyncPartCodeBlockLazy.java
 * @author YangJianWei
 * @date 2018年8月27日 下午2:47:55 
 * @version $Id: v 0.1 
 */
public class SyncPartCodeBlockLazy {

    private SyncPartCodeBlockLazy() {

    }

    private static SyncPartCodeBlockLazy singleton = null;

    public static SyncPartCodeBlockLazy getSingleton() {
        if (singleton == null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new SyncPartCodeBlockLazy();
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(SyncPartCodeBlockLazy.getSingleton());
                }
            }).start();
        }
    }
}
