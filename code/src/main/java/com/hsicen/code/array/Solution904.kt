package com.hsicen.code.array

import kotlin.math.max

/**
 * @author: hsc
 * @date: 2025/6/20 17:20
 * @email: codinghuang@163.com
 * @description: 094.水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *   1.你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 *   2.你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 *   3.一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 *
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目
 * 示例 1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘 [1,2,1] 的 3 棵树。
 *
 * 示例 2：
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 的 3 棵树。
 *
 * 示例 3：
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 的 4 棵树。
 *
 * 示例 4：
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 的 5 棵树。
 */
class Solution904 {
    fun totalFruit(fruits: IntArray): Int {
        if (fruits.size <= 2) return fruits.size

        var resultLen = 0
        var slowIndex = 0
        val kinds = HashMap<Int, Int>()

        for (fastIndex in fruits.indices) {
            kinds.put(fruits[fastIndex], kinds.getOrDefault(fruits[fastIndex], 0) + 1)

            while (kinds.size > 2) { // 当水果种类大于2时，移动慢指针
                kinds.put(fruits[slowIndex], kinds[fruits[slowIndex]]!! - 1) // 按顺序移除慢指针指向的水果
                if (kinds[fruits[slowIndex]] == 0) {
                    kinds.remove(fruits[slowIndex])
                }

                ++slowIndex // 移动慢指针
            }

            resultLen = max(resultLen, fastIndex - slowIndex + 1)
        }

        return resultLen
    }
}

fun main() {
    val solution = Solution904()

    val fruits = intArrayOf(1, 2, 1)
    println("${fruits.joinToString(prefix = "[", postfix = "]")} 可采摘的最大果树为：${solution.totalFruit(fruits)}")

    val fruits2 = intArrayOf(0, 1, 2, 2)
    println("${fruits2.joinToString(prefix = "[", postfix = "]")} 可采摘的最大果树为：${solution.totalFruit(fruits2)}")

    val fruits3 = intArrayOf(1, 2, 3, 2, 2)
    println("${fruits3.joinToString(prefix = "[", postfix = "]")} 可采摘的最大果树为：${solution.totalFruit(fruits3)}")

    val fruits4 = intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)
    println("${fruits4.joinToString(prefix = "[", postfix = "]")} 可采摘的最大果树为：${solution.totalFruit(fruits4)}")

    val fruits5 = intArrayOf(1, 2, 3, 2, 2, 1, 1, 2, 3, 3, 4)
    println("${fruits5.joinToString(prefix = "[", postfix = "]")} 可采摘的最大果树为：${solution.totalFruit(fruits5)}")
}