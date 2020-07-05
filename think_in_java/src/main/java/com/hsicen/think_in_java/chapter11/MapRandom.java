package com.hsicen.think_in_java.chapter11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 作者：hsicen  2020/6/29 14:52
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：统计数字出现的次数
 */
class MapRandom {

    public static void main(String[] args) {
        Random random = new Random(47);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            int num = random.nextInt(2);
            Integer value = hashMap.get(num);
            hashMap.put(num, value == null ? 1 : value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> o1 - o2);


        System.out.println(hashMap);
    }
}
