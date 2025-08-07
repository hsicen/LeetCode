package com.hsicen.code.hashmap


/**
 * @author: hsc
 * @date: 2025/8/7 14:29
 * @email: codinghuang@163.com
 * @description: 18.四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *      0 <= a, b, c, d < n
 *      a、b、c 和 d 互不相同
 *      nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
object Solution18 {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums.size < 4) return result

        // 排序数组
        nums.sort()

        for (i in 0 until nums.size - 3) {
            // 去重：如果当前数字与前一个数字相同，则跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue

            for (j in (i + 1) until nums.size - 2) {
                // 去重：如果当前数字与前一个数字相同，则跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) continue

                var left = j + 1
                var right = nums.size - 1

                while (left < right) {
                    val sum =
                        nums[i].toLong() + nums[j].toLong() + nums[left].toLong() + nums[right].toLong()

                    when {
                        sum == target.toLong() -> {
                            result.add(listOf(nums[i], nums[j], nums[left], nums[right]))

                            // 去重
                            while (left < right && nums[left] == nums[left + 1]) left++
                            while (left < right && nums[right] == nums[right - 1]) right--

                            left++
                            right--
                        }

                        sum < target -> {
                            left++
                        }

                        else -> {
                            right--
                        }
                    }
                }
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 0, -1, 0, -2, 2)
        val target = 0
        val result = fourSum(nums, target)
        println(result)

        val nums2 = intArrayOf(2, 2, 2, 2, 2)
        val target2 = 8
        val result2 = fourSum(nums2, target2)
        println(result2)
    }
}