package com.hsicen.code.array


/**
 * @author: hsc
 * @date: 2025/6/19 18:56
 * @email: codinghuang@163.com
 * @description: 977.有序数组的平方
 *  给你一个按 非递减顺序 排列的整数数组 nums ，
 *  返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排列。
 *
 *  示例 1：
 *  输入：nums = [-4,-1,0,3,10]
 *  输出：[0,1,9,16,100]
 *  解释：平方后，数组变为 [16,1,0,9,100]
 *       排序后，数组变为 [0,1,9,16,100]
 *
 *  示例 2：
 *  输入：nums = [-7,-3,2,3,11]
 *  输出：[4,9,9,49,121]
 */
class Solution977 {

    // 利用归并排序思路，找到负数和非负数的分界点，然后对应比较
    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums
        if (nums.size == 1) {
            nums[0] = nums[0] * nums[0]
            return nums
        }

        var gap = 0
        for (pos in nums.indices) {
            if (nums[pos] < 0) {
                gap = pos
            } else {
                break
            }
        }

        val result = IntArray(nums.size)
        var index = nums.size - 1

        var lefIndex = 0
        var rightIndex = nums.size - 1
        while (lefIndex <= gap && rightIndex > gap) {
            val leftSquare = nums[lefIndex] * nums[lefIndex]
            val rightSquare = nums[rightIndex] * nums[rightIndex]

            if (leftSquare > rightSquare) {
                result[index--] = leftSquare
                lefIndex++
            } else {
                result[index--] = rightSquare
                rightIndex--
            }
        }

        if (lefIndex <= gap) {
            for (pos in lefIndex..gap) {
                result[index--] = nums[pos] * nums[pos]
            }
        }

        if (rightIndex > gap) {
            for (pos in rightIndex downTo gap + 1) {
                result[index--] = nums[pos] * nums[pos]
            }
        }

        return result
    }

    // 利用快慢指针法，从两头往中间比较
    fun sortedSquares2(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums
        if (nums.size == 1) {
            nums[0] = nums[0] * nums[0]
            return nums
        }

        val result = IntArray(nums.size)

        var leftIndex = 0
        var rightIndex = nums.size - 1
        var index = nums.size - 1

        while (leftIndex <= rightIndex && index >= 0) {
            val leftSquare = nums[leftIndex] * nums[leftIndex]
            val rightSquare = nums[rightIndex] * nums[rightIndex]

            if (leftSquare > rightSquare) {
                result[index--] = leftSquare
                leftIndex++
            } else {
                result[index--] = rightSquare
                rightIndex--
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution977()
    val nums = intArrayOf(-4, -1, 0, 3, 10)
    print("原数组：${nums.joinToString()} 平方后: ")
    println(solution.sortedSquares2(nums).joinToString())

    val nums2 = intArrayOf(-7, -3, 2, 3, 11)
    print("原数组：${nums2.joinToString()} 平方后: ")
    println(solution.sortedSquares2(nums2).joinToString())

    val nums3 = intArrayOf(-7, -4, -3, -2, -1, 0, 1, 9, 16, 100)
    print("原数组：${nums3.joinToString()} 平方后: ")
    println(solution.sortedSquares2(nums3).joinToString())

    val nums4 = intArrayOf(-11, -5, -4, -2, -1, 0, 1, 9, 16, 100, 104, 109, 109)
    print("原数组：${nums4.joinToString()} 平方后: ")
    println(solution.sortedSquares2(nums4).joinToString())
}