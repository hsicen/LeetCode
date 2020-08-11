package com.hsicen.think_in_java.chapter13;

import java.util.ArrayList;

/**
 * 作者：hsicen  2020/8/11 22:44
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：toString()的递归调用
 */
class InfiniteRecursion {

    public String toString() {
        return "InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        ArrayList<InfiniteRecursion> recursions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            recursions.add(new InfiniteRecursion());
        }

        System.out.println(recursions);
    }
}
