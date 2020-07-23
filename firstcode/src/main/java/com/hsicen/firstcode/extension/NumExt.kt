package com.hsicen.firstcode.extension

/**
 * 作者：hsicen  2020/7/23 19:26
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：数字扩展
 */

fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("Params is empty")

    var maxNum = nums[0]
    for (num in nums) {
        if (num > maxNum) maxNum = num
    }

    return maxNum
}

fun <T : Comparable<T>> min(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("Params is empty")

    var minNum = nums[0]
    for (num in nums) {
        if (num < minNum) minNum = num
    }

    return minNum
}