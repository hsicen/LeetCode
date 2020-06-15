package com.hsicen.think_in_java.chapter8;

/**
 * 作者：hsicen  2020/6/14 18:00
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：相等性测试
 */
class TestEquals {

    public static void main(String[] args) {

        //baseType();

        referenceType();
    }

    private static void referenceType() {
        Integer a = new Integer(8);
        Integer b = new Integer(9);
        Integer c = new Integer(9);

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

    private static void baseType() {
        int a = 8;
        int b = 9;
        int c = 9;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }


}
