package com.yjw.interview.interview.单例;

/**
 * 懒汉模式（线程安全、）
 * 
 * 实例变量的hashCode值一致，说明对象是同一个，使用synchronized关键字修饰全部代码块的懒汉式单例实现是线程安全的。
 * 这种实现方式其实和synchronized修饰方法的实现方式优缺点一致。
 * 
 * @description SyncFullCodeBlockLazy.java
 * @author YangJianWei
 * @date 2018年8月27日 下午2:34:02
 * @version $Id: v 0.1  
 */
public class SyncFullCodeBlockLazy {

    private SyncFullCodeBlockLazy() {

    }

    private static SyncFullCodeBlockLazy singleton = null;

    public static SyncFullCodeBlockLazy getSingleton() {
        synchronized (SyncFullCodeBlockLazy.class) {
            if (singleton == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton = new SyncFullCodeBlockLazy();
            }
            return singleton;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(SyncFullCodeBlockLazy.getSingleton());
                }
            }).start();
        }
    }
}
