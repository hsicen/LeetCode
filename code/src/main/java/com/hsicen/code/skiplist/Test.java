package com.hsicen.core.skiplist;

/**
 * <p>作者：hsicen  2019/11/27 16:46
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：跳表测试
 */
public class Test {

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.add(9);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(9);
        list.erase(2);
        list.erase(1);
        list.add(2);
        list.search(7);
        list.search(4);
        list.add(5);
        list.erase(6);
        list.search(5);
        list.add(6);
        list.add(7);
        list.add(4);
        list.erase(3);
        list.search(6);
        list.erase(3);
        list.search(4);
        list.search(3);
        list.search(8);
        list.erase(7);
        list.erase(6);
        list.search(7);
        list.erase(4);
        list.add(1);
        list.add(6);
        list.erase(3);
        list.add(4);
        list.search(7);
        list.search(6);
        list.search(1);
        list.search(0);
        list.search(3);
    }
}
