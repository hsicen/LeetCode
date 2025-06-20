package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/20 15:50
 * @email: codinghuang@163.com
 * @description: 209.长度最小的子数组
 *  给定一个含有 n 个正整数的数组和一个正整数 target 。
 *  找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 *  如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 和 [3,1,2] 都是满足其总和大于等于 target 的子数组，长度最小为 2。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
class Solution209 {

    // 暴力法，双循环求解
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var resultLen = nums.size + 1
        var sum = 0
        var tmpLen = 0

        for (firstIndex in nums.indices) {
            sum = 0
            for (secondIndex in firstIndex until nums.size) {
                sum += nums[secondIndex]
                if (sum >= target) {
                    tmpLen = secondIndex - firstIndex + 1
                    resultLen = if (resultLen < tmpLen) resultLen else tmpLen
                    break
                }
            }
        }

        return if (resultLen == nums.size + 1) 0 else resultLen
    }

    // 滑动窗口法，双指针移动求解
    // 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
    // 窗口的起始位置如何移动：如果当前窗口的值大于等于s了，窗口就要向前移动了（也就是该缩小了）。
    // 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
    fun minSubArrayLen2(target: Int, nums: IntArray): Int {
        var resultLen = nums.size + 1
        var sum = 0
        var tmpLen = 0
        var slowIndex = 0

        for (fastIndex in nums.indices) {
            sum += nums[fastIndex] // 先找到窗口区间

            while (sum >= target) { // 再从上面的窗口区间移动起始窗口
                tmpLen = fastIndex - slowIndex + 1
                resultLen = if (resultLen < tmpLen) resultLen else tmpLen
                sum -= nums[slowIndex++] // 移动起始窗口
            }
        }

        return if (resultLen == nums.size + 1) 0 else resultLen
    }
}

fun main() {
    val solution = Solution209()

    var nums = intArrayOf(2, 3, 1, 2, 4, 3)
    var target = 7
    print("${nums.joinToString()} 中最小子数组和为${target}的长度是：")
    println(solution.minSubArrayLen2(target, nums))

    nums = intArrayOf(1, 4, 4)
    target = 4
    print("${nums.joinToString()} 中最小子数组和为${target}的长度是：")
    println(solution.minSubArrayLen2(target, nums))

    nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
    target = 11
    print("${nums.joinToString(prefix = "[", postfix = "]")} 中最小子数组和为${target}的长度是：")
    println(solution.minSubArrayLen2(target, nums))
}