package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/17 19:19
 * @email: codinghuang@163.com
 * @description: 283.移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
class Solution283 {

    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty() || nums.size == 1) return

        // 快慢指针法，先将非0元素移动到前面
        var slowIndex = 0
        for (fastIndex in nums.indices) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex]
            }
        }

        // 然后将剩余位置元素重置为0
        for (pos in slowIndex until nums.size) {
            nums[pos] = 0
        }
    }
}

fun main() {
    val solution = Solution283()

    val nums = intArrayOf(0, 1, 0, 3, 12)
    solution.moveZeroes(nums)
    println(nums.joinToString())

    val nums2 = intArrayOf(0)
    solution.moveZeroes(nums2)
    println(nums2.joinToString())

    val nums3 = intArrayOf(0, 0, 1)
    solution.moveZeroes(nums3)
    println(nums3.joinToString())
}