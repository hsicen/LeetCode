package com.hsicen.think_in_java.chapter11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 作者：hsicen  2020/6/27 21:55
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class AppleAndOrangeHolds {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Apple());
        list.add(new Apple());
        list.add(new Apple());
        list.add(new Apple());
        list.add(new Orange());

        for (Object apple : list) {
            System.out.println(((Apple) apple).id());
        }

        ListIterator listIterator = list.listIterator();
        listIterator.nextIndex();
        listIterator.previousIndex();


        LinkedList<Apple> apples = new LinkedList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        Apple apple = apples.get(9);
    }
}
