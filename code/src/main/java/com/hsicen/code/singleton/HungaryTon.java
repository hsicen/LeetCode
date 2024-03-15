package com.hsicen.core.singleton;

/**
 * 作者：hsicen  2020/5/19 8:41
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：饿汉式单例模式
 * 调用getInstance() 方法时，才会触发HungaryTon的初始化
 */
public class HungaryTon {
    private static final HungaryTon instance = new HungaryTon();

    private HungaryTon() {
    }

    /*** 只暴露这一个方法给外部调用*/
    public static HungaryTon getInstance() {
        return instance;
    }
}
