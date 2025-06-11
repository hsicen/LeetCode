package com.hsicen.code.array

import kotlin.math.abs

/**
 * @author: hsc
 * @date: 2025/6/11 15:01
 * @email: codinghuang@163.com
 * @description:
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 *
 * 进阶：不要 使用任何内置的库函数，如sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *
 * 提示：1 <= num <= 231 - 1
 */
class Solution367 {

    // 使用二分法处理，假设区间[left,right]，关键考虑范围溢出问题
    fun isPerfectSquare(num: Int): Boolean {
        if (0 == num || 1 == num) return true

        var left = 1
        var right = num
        while (left <= right) {
            val mid = left + (right - left) / 2L
            val square = mid * mid

            if (square == (num * 1L)) return true
            if (square > (num * 1L)) {
                right = (mid - 1).toInt()
            } else {
                left = (mid + 1).toInt()
            }
        }

        return false
    }

    // 使用牛顿迭代法处理
    fun isPerfectSquare2(num: Int): Boolean {
        if (1 == num) return true

        var x = num.toDouble()
        val eps = 0.1
        while (abs(x - num / x) > eps) {
            x = (x + num / x) / 2
        }

        return x.toInt() * x.toInt() == num
    }

    //暴力循环遍历数组
    fun isPerfectSquare3(num: Int): Boolean {
        if (1 == num) return true
        return (1..num / 2).any {
            (it * 1L) * (it * 1L) == num * 1L
        }
    }

    // 二项式定理求解
    fun isPerfectSquare4(num: Int): Boolean {
        var step = 1
        var remain = num

        while (remain > 0) {
            remain = remain - step
            step = step + 2
        }

        return remain == 0
    }
}

fun main() {
    val solution = Solution367()
    val num = 16
    println("num=$num, isPerfectSquare=${solution.isPerfectSquare4(num)}")

    val num2 = 14
    println("num=$num2, isPerfectSquare=${solution.isPerfectSquare(num2)}")

    val num3 = 5
    println("num=$num3, isPerfectSquare=${solution.isPerfectSquare4(num3)}")

    val num4 = 2147483647
    println("num=$num4, isPerfectSquare=${solution.isPerfectSquare4(num4)}")
}