package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/7/14 16:27
 * @email: codinghuang@163.com
 * @description: 349.两个数组的交集
 * 给定两个数组nums1和nums2 ，返回 它们的交集。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
object Solution349 {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = hashSetOf<Int>()
        nums1.forEach { set1.add(it) }

        val result = mutableListOf<Int>()
        nums2.forEach {
            if (set1.contains(it)) {
                result.add(it)
                set1.remove(it)
            }
        }

        return result.toIntArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2, 2)
        val result = intersection(nums1, nums2)
        println(result.joinToString())
    }
}