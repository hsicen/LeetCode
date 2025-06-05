package com.hsicen.code.array

/**
 * @author: hsicen
 * @date: 2025/6/5 21:52
 * @email: codinghuang@163.com
 * @description: 704. 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
class Solution704 {

    // 假设目标值在 [left, right] 区间
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return -1
    }


    // 假设目标值在 [left, right) 区间
    fun search2(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size
        while (start < end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                end = mid
            } else {
                start = mid + 1
            }
        }

        return -1
    }
}

fun main() {
    val method = Solution704()

    val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
    var target = 9
    val result = method.search(nums, target)
    println("target $target in array ${nums.toList()} pos is：$result")

    target = 0
    val result2 = method.search2(nums, target)
    println("target $target in array ${nums.toList()} pos is：$result2")
}