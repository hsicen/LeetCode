package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/12 15:40
 * @email: codinghuang@163.com
 * @description:
 *
 * 26. 删除排序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 1.更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 2.返回 k
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 */
class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        for (i in 0 until nums.size) {
            if (nums[i] != nums[index]) {
                index++
                nums[index] = nums[i]
            }
        }

        return index + 1
    }
}

fun main() {
    val solution26 = Solution26()
    var nums = intArrayOf(1, 1, 2)
    val newSize = solution26.removeDuplicates(nums)
    println("newSize = $newSize")
    println("nums = ${nums.toList()}")

    nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val newSize2 = solution26.removeDuplicates(nums)
    println("newSize2 = $newSize2")
    println("nums = ${nums.toList()}")
}