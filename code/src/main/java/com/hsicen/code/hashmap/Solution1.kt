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
        if (nums.isEmpty()) return intArrayOf()
        val map = HashMap<Int, Int>()

        for (pos in nums.indices) {
            val tmp = nums[pos]
            val diff = target - tmp

            if (map.containsKey(diff)) {
                return intArrayOf(map[diff]!!, pos)
            } else {
                map[tmp] = pos
            }
        }

        return intArrayOf()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(2, 7, 11, 15)
        println(twoSum(nums, 9).contentToString())

        val nums2 = intArrayOf(3, 2, 4)
        println(twoSum(nums2, 6).contentToString())

        val nums3 = intArrayOf(3, 3)
        println(twoSum(nums3, 6).contentToString())

        val nums4 = intArrayOf(3, 2, 4, 7)
        println(twoSum(nums4, 12).contentToString())
    }
}