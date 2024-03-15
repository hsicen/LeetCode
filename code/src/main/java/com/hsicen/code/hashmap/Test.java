package com.hsicen.code.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>作者：hsicen  2019/11/28 14:17
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：散列表测试
 */
public class Test {

    public static void main(String[] args) {

        testLinkedHashMap();
    }


    private static void testLinkedHashMap() {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>(6, 0.75f, true);
        hashMap.put(3, 8);
        hashMap.put(6, 9);
        hashMap.put(4, 7);
        hashMap.put(1, 5);
        hashMap.put(2, 6);

        hashMap.get(4);
        hashMap.get(6);

        for (Map.Entry index : hashMap.entrySet()) {
            System.out.println("key：" + index.getKey() + "  value：" + index.getValue());
        }
    }
}
