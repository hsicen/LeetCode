package com.hsicen.core.recursive

/**
 * <p>作者：Night  2019/1/23 21:20
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode 852
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 */

fun main(args: Array<String>) {

}

fun peakIndexInMountainArray(A: IntArray): Int {
    var l = 0
    var h = A.size - 1
    var m = h - (h - l) / 2

    while (l < h) {
        if (A[m] > A[m - 1] && A[m] > A[m + 1]) break;
        if (A[m] < A[m + 1]) l = m else h = m
        m = h - (h - l) / 2
    }
    return m
}
