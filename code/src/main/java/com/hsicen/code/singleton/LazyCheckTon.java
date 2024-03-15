package com.hsicen.code.singleton;

/**
 * 作者：hsicen  2020/5/19 9:29
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：实现线程安全的懒汉式单例
 * 思路：
 * 1.使用volatile关键字保证instance操作是happens-before的，前一个线程操作的结果对后一个线程是可见的
 * 2.getInstance()方法采用了双重检测机制，确保instance为空时才创建实例
 * <p>
 * 使用volatile和synchronized关键字都是为了保证操作遵循happens-before原则
 */
public class LazyCheckTon {
    private static volatile LazyCheckTon instance;

    private LazyCheckTon() {
    }

    public static LazyCheckTon getInstance() {
        if (null == instance) {
            synchronized (LazyCheckTon.class) {
                if (null == instance) {
                    instance = new LazyCheckTon();
                }
            }
        }

        return instance;
    }
}
