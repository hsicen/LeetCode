package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/8 20:48
 * @email: codinghuang@163.com
 * @description:
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的算术平方根 。
 * 请注意，返回的整数应当符合 平方根 整数要求：
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
class Solution69 {
    // 使用二分法处理，假设区间在[1,x]，找到第一个 left<=right 且 小于等于x/mid的数，然后返回left-1
    fun mySqrt(x: Int): Int {
        if (x == 0 || x == 1) return x

        var left = 1
        var right = x
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid == x / mid) return mid
            if (mid < x / mid) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return right
    }


}

fun main() {
    val solution = Solution69()
    val target1 = 8
    println("$target1 的平方根是：${solution.mySqrt(target1)}")

    val target2 = 4
    println("$target2 的平方根是：${solution.mySqrt(target2)}")

    val target3 = 0
    println("$target3 的平方根是：${solution.mySqrt(target3)}")

    val target4 = 1
    println("$target4 的平方根是：${solution.mySqrt(target4)}")

    val target5 = 2
    println("$target5 的平方根是：${solution.mySqrt(target5)}")

    val target6 = 3
    println("$target6 的平方根是：${solution.mySqrt(target6)}")

    val target7 = 9
    println("$target7 的平方根是：${solution.mySqrt(target7)}")

    val target8 = 70
    println("$target8 的平方根是：${solution.mySqrt(target8)}")
}