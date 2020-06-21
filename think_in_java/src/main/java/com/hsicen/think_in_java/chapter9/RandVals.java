package com.hsicen.think_in_java.chapter9;

import java.util.Random;

/**
 * 作者：hsicen  2020/6/20 22:29
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
public interface RandVals {
    Random RANDOM = new Random(47);
    int RAND_INT = RANDOM.nextInt(10);
}
