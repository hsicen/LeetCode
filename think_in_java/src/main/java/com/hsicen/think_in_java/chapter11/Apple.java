package com.hsicen.think_in_java.chapter11;

/**
 * 作者：hsicen  2020/6/27 21:52
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class Apple {
    private static long counter;
    private final long id = ++counter;

    public long id() {
        return id;
    }
}
