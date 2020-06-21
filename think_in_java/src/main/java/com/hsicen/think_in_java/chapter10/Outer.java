package com.hsicen.think_in_java.chapter10;

/**
 * 作者：hsicen  2020/6/21 14:55
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：内部类
 */
class Outer {

    Inner getInner() {
        return new Inner(5);
    }

    private String str = "Hello!!!";

    class Inner {
        int anInt = 1;

        int value;

        Inner(int s) {
            value = s;
        }

        void strToString() {
            str = "Hello World";
            System.out.println("Outer: " + str);
        }
    }

}
