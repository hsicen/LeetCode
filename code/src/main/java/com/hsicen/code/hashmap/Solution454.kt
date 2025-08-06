package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/7/15 18:24
 * @email: codinghuang@163.com
 * @description: 454.四数相加
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 *
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 **/
object Solution454 {

    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        // 统计nums1和nums2所有可能的和
        for (i in nums1) {
            for (j in nums2) {
                map[i + j] = map.getOrDefault(i + j, 0) + 1
            }
        }

        var count = 0
        // 遍历nums3和nums4，寻找complement
        for (k in nums3) {
            for (l in nums4) {
                count += map.getOrDefault(-k - l, 0)
            }
        }

        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(-2, -1)
        val nums3 = intArrayOf(-1, 2)
        val nums4 = intArrayOf(0, 2)
        println("Test 1: ${fourSumCount(nums1, nums2, nums3, nums4)}")

        val nums1_2 = intArrayOf(0)
        val nums2_2 = intArrayOf(0)
        val nums3_2 = intArrayOf(0)
        val nums4_2 = intArrayOf(0)
        println("Test 2: ${fourSumCount(nums1_2, nums2_2, nums3_2, nums4_2)}")
    }
}