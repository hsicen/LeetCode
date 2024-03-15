package com.hsicen.code.recursive

/**
 * <p>作者：Night  2019/1/24 20:40
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode  爬楼梯
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Note: Given n will be a positive integer.
 */

fun main() {

}

fun climbStairs(n: Int): Int {
    val dp = IntArray(n + 3) {
        0
    }
    dp[0] = 1
    dp[1] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}

