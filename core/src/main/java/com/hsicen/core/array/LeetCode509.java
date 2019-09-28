package com.hsicen.core.array;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * <p>作者： Hsicen  2019/8/23 9:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * https://leetcode.com/problems/fibonacci-number/
 * <p>
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * <p>
 * 思路：由于数组是有序数组，故数组平方的最大值一定在数组的两端产生，
 * 则可以从数组的两端往中间比较，得出最大的值由新数组的末尾往头开始添加
 */
public class LeetCode509 {

    public static void main(String[] args) {
        println(" 2 is  " + fib(2));
        println(" 3 is  " + fib(3));
    }

    private static int fib(int N) {
        if (0 == N || 1 == N) {
            return N;
        }

        return fib(N - 1) + fib(N - 2);
    }

}
