package com.hsicen.think_in_java.chapter1;

/**
 * 作者：hsicen  2020/6/6 21:14
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class Test1 {
    int test1;
    char test2;

    public Test1(int test1) {
        this.test1 = test1;
    }

    public void say(String name, int age) {
        System.out.println("The name is " + name + ", the age is " + age);
    }

    public void say(int age, String name) {
        System.out.println("The name is " + name + ", the age is " + age);
    }
}
