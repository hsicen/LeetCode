package com.hsicen.think_in_java.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 作者：hsicen  2020/6/27 22:14
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer[] moreInts = {1, 2, 3, 4, 8, 5, 6, 7};
        integers.addAll(Arrays.asList(moreInts));
        Collections.addAll(integers, 12, 3, 4, 5, 6);
        Collections.addAll(integers, moreInts);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.set(1, 44);
        list.add(1);
    }
}
