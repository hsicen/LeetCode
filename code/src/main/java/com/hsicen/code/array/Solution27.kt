package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/12 14:43
 * @email: codinghuang@163.com
 * @description:
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 *
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,4]
 */
class Solution27 {
    // 使用快慢指针求解
    fun removeElement(nums: IntArray, val1: Int): Int {
        var slowIndex = 0
        for (fastIndex in nums.indices) {
            if (nums[fastIndex] != val1) {
                nums[slowIndex++] = nums[fastIndex]
            }
        }
        return slowIndex
    }
}

fun main() {
    val solution27 = Solution27()
    val nums = intArrayOf(3, 2, 2, 3)
    val val1 = 3
    print("数组 [${nums.joinToString()}] 移除元素 $val1 ")
    val count = solution27.removeElement(nums, val1)
    println("后的数组长度为 $count\n")

    val nums2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val val2 = 2
    print("数组 [${nums2.joinToString()}] 移除元素 $val2 ")
    val count2 = solution27.removeElement(nums2, val2)
    println("后的数组长度为 $count2\n")
}