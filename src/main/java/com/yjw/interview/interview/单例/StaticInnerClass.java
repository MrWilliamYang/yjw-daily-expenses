package com.yjw.interview.interview.单例;

/**
 * 
 * 
 * 实例变量的hashCode值不一致，说明对象不是同一个，使用静态内部类方式的懒汉式单例实现是线程安全的。
 * 虽然咋看上去这种方式和第一种饿汉模式的单例模式一样，两者都是采用了类装载的机制来保证初始化实例时只有一个线程，
 * 但是有区别的地方在于静态内部类方式在StaticInnerClass类被装载时并不会立即实例化，而是在需要实例化时，
 * 调用getInstance方法，才会装载StaticInnerClassProvider类，从而完成StaticInnerClass的实例化，所以这种方式也值得推荐。
 * 
 * @description StaticInnerClass.java,
 * @author YangJianWei
 * @date 2018年8月28日 下午2:09:09 
 * @version $Id:  v 0.1 
 */
public class StaticInnerClass {

    private StaticInnerClass() {

    }

    private static class StaticInnerClassProvider {
        private static StaticInnerClass singleton = new StaticInnerClass();
    }

    public static StaticInnerClass getSingleton() {
        return StaticInnerClassProvider.singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(StaticInnerClass.getSingleton());
                }
            }).start();
        }
    }
}
