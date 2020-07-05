package com.hsicen.think_in_java.chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 作者：hsicen  2020/6/28 22:33
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class IteratorTest {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            apples.add(new Apple());
        }

        Iterator<Apple> iterator = apples.iterator();
        while (iterator.hasNext()) {
            Apple next = iterator.next();
            System.out.println(next + " 当前id：" + next.id());
        }

        System.out.println("==========ListIterator=========");
        ListIterator<Apple> listIterator = apples.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().id());
        }

        Apple[] arr = {new Apple(), new Apple()};
        Apple apple = arr[0];
        System.out.println(apple + " " + apple.id());
    }
}
