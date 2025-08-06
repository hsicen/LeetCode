package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/8/6 17:23
 * @email: codinghuang@163.com
 * @description: 15.三数之和
 * 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 */
object Solution15 {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums.size < 3) return result

        // 排序数组
        nums.sort()

        for (i in 0 until nums.size - 2) {
            // 如果当前数字大于0，则三数之和一定大于0，结束循环
            if (nums[i] > 0) break

            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                if (sum == 0) {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--

                    left++
                    right--
                } else if (sum < 0) {
                    left++
                } else {
                    right--
                }
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val result = threeSum(nums)
        println(result)

        val nums2 = intArrayOf(0, 1, 1)
        val result2 = threeSum(nums2)
        println(result2)

        val nums3 = intArrayOf(0, 0, 0)
        val result3 = threeSum(nums3)
        println(result3)
    }
}