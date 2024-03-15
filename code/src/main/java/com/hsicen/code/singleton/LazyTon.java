package com.hsicen.core.singleton;

/**
 * 作者：hsicen  2020/5/19 9:18
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：标准的懒汉式单例模式(会有线程安全问题)
 */
public class LazyTon {
    private static LazyTon instance;

    private LazyTon() {

    }

    public static LazyTon getInstance() {
        if (null == instance) {
            instance = new LazyTon();
        } //这里会有线程安全问题

        return instance;
    }
}
