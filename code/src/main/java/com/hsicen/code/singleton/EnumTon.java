package com.hsicen.code.singleton;

/**
 * 作者：hsicen  2020/5/19 9:00
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：枚举单例，和饿汉式相似
 */
public enum EnumTon {
    INSTANCE;

    public static EnumTon getInstance() {
        return INSTANCE;
    }
}
