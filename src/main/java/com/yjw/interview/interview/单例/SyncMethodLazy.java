package com.yjw.interview.interview.单例;

/**
 * 懒汉模式（线程安全、懒加载、单线程）
 * 
 * 实例变量的hashCode值一致，说明对象是同一个，使用synchronized关键字的懒汉式单例实现是线程安全的。
 * 优点是实现了线程安全并且是懒加载的；缺点是在同一时刻getSingleton方法只能由一个线程访问，效率会很低。
 * 
 * @description SyncMethodLazy.java
 * @author YangJianWei
 * @date 2018年8月27日 下午2:23:44
 * @version $Id: v 0.1  
 */
public class SyncMethodLazy {

    private SyncMethodLazy() {

    }

    private static SyncMethodLazy singleton = null;

    public static synchronized SyncMethodLazy getSingleton() {
        if (singleton == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new SyncMethodLazy();
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(SyncMethodLazy.getSingleton());
                }
            }).start();
        }
    }
}
