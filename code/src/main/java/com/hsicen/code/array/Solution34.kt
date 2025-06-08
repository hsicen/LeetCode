package com.hsicen.code.array


/**
 * @author: hsc
 * @date: 2025/6/7 20:56
 * @email: codinghuang@163.com
 * @description:
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *  如果数组中不存在目标值 target，返回[-1, -1]。
 *  你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *  示例 1：
 *  输入：nums = [5,7,7,8,8,10], target = 8
 *  输出：[3,4]
 *
 *  示例 2：
 *  输入：nums = [5,7,7,8,8,10], target = 6
 *  输出：[-1,-1]
 *
 *  示例 3：
 *  输入：nums = [], target = 0
 *  输出：[-1,-1]
 *
 *  提示：
 *  0 <= nums.length <= 105
 *  -109 <= nums[i] <= 109
 *  nums 是一个非递减数组
 */
class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        // 提前判断首位末端情况
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        if (nums[0] > target) return intArrayOf(-1, -1)
        if (nums[nums.size - 1] < target) return intArrayOf(-1, -1)

        val left = searchLeftRange(nums, target)
        val right = searchRightRange(nums, target)

        // 在首尾末端都没找到
        if (left == -2 || right == -2) return intArrayOf(-1, -1)

        // 找到对应的值，插值为1表示至少有一个值
        if (right - left > 1) return intArrayOf(left + 1, right - 1)

        // 在数组中没找到值
        return intArrayOf(-1, -1)
    }

    // 假设查找区间为[left,right], 将right移动到小于target的第一个值的位置
    fun searchLeftRange(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var leftBorder = -2

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] >= target) {
                right = mid - 1
                leftBorder = right
            } else {
                left = mid + 1
            }
        }

        return leftBorder
    }

    // 假设查找区间为[left,right], 将left移动到大于target的第一个值的位置
    fun searchRightRange(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var rightBorder = -2

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] <= target) {
                left = mid + 1
                rightBorder = left
            } else {
                right = mid - 1
            }
        }

        return rightBorder
    }
}

fun main() {
    val solution = Solution34()
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 8
    val result = solution.searchRange(nums, target)
    println("result = ${result.joinToString()}")

    val nums2 = intArrayOf(1)
    val target2 = 1
    val result2 = solution.searchRange(nums2, target2)
    println("result2 = ${result2.joinToString()}")
}