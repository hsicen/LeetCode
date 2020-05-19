package com.hsicen.core.singleton;

import java.io.Serializable;

/**
 * 作者：hsicen  2020/5/19 8:51
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：静态内部类单例
 * 只有静态内部类初始化的时候，才会实例化单例对象
 * 即使StaticTon类加载到内存中，也不会实例化对象
 */
public class StaticTon implements Serializable {

    private static class SingletonHolder {
        private static final StaticTon INSTANCE = new StaticTon();
    }

    private StaticTon() {
    }

    public static StaticTon getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //防止反序列化的时候通过反射创建新的实例
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

}
