package com.hsicen.think_in_java.chapter10;

/**
 * 作者：hsicen  2020/6/21 14:56
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class InnerTest {

    public static void main(String[] args) {

        Outer outer = new Outer();

        Outer.Inner inner = outer.getInner();
        inner.value = 10;

        Outer.Inner inner1 = outer.new Inner(4);
    }
}
