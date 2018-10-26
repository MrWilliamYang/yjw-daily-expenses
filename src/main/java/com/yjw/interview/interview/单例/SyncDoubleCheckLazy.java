package com.yjw.interview.interview.单例;

/**
 * 懒汉模式（带双重检查、线程安全、效率高、推荐使用）
 * 
 * 实例变量的hashCode值不一致，说明对象不是同一个，使用synchronized关键字双重检查的懒汉式单例实现是线程安全的。
 * 其实这种方式是综合了第三、四、五这三种实现方式，即实现了线程安全，也相对提高了运行效率，值得推荐。
 * 
 * @description SyncDoubleCheckLazy.java
 * @author YangJianWei
 * @date 2018年8月27日 下午2:56:19 
 * @version $Id: v 0.1 
 */
public class SyncDoubleCheckLazy {

    private SyncDoubleCheckLazy() {

    }

    private static SyncDoubleCheckLazy singleton = null;

    public static SyncDoubleCheckLazy getSingleton() {
        if (singleton == null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SyncDoubleCheckLazy.class) {
                if (singleton == null) {
                    singleton = new SyncDoubleCheckLazy();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(SyncDoubleCheckLazy.getSingleton());
                }
            }).start();
        }
    }
}
