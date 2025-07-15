package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/7/15 14:42
 * @email: codinghuang@163.com
 * @description: 1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
object Solution1 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size < 2) return intArrayOf()
        val map = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            val complement = target - num
            map[complement]?.let { return intArrayOf(it, index) }
            map[num] = index
        }

        return intArrayOf()
    }

    // 优化版本：使用更简洁的写法
    fun twoSumOptimized(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        return nums.mapIndexed { index, num ->
            val complement = target - num
            map[complement]?.let { return intArrayOf(it, index) }
            map[num] = index
        }.let { intArrayOf() }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(2, 7, 11, 15)
        println("Original: ${twoSum(nums, 9).contentToString()}")
        println("Optimized: ${twoSumOptimized(nums, 9).contentToString()}")

        val nums2 = intArrayOf(3, 2, 4)
        println("Original: ${twoSum(nums2, 6).contentToString()}")
        println("Optimized: ${twoSumOptimized(nums2, 6).contentToString()}")

        val nums3 = intArrayOf(3, 3)
        println("Original: ${twoSum(nums3, 6).contentToString()}")
        println("Optimized: ${twoSumOptimized(nums3, 6).contentToString()}")

        val nums4 = intArrayOf(3, 2, 4, 7)
        println("Original: ${twoSum(nums4, 12).contentToString()}")
        println("Optimized: ${twoSumOptimized(nums4, 12).contentToString()}")
    }
}