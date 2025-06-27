package com.hsicen.code.array


/**
 * @author: hsc
 * @date: 2025/6/27 15:56
 * @email: codinghuang@163.com
 * @description: 59.螺旋矩阵2
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
class Solution59 {

    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) } // 创建 n×n 的二维数组
        var num = 1  // 当前要填充的数字（从1开始）

        var top = 0  // 上边界（初始为第0行）
        var bottom = n - 1  // 下边界（初始为第n-1行）
        var left = 0  // 左边界（初始为第0列）
        var right = n - 1  // 右边界（初始为第n-1列）

        while (num <= n * n) { // 循环填充数字，直到填满所有数字（1~n²）
            // 1. 从左到右填充上边界
            for (i in left..right) {
                matrix[top][i] = num++
            }
            top++

            // 2. 从上到下填充右边界
            for (i in top..bottom) {
                matrix[i][right] = num++
            }
            right--

            // 3. 从右到左填充下边界
            if (top <= bottom) {  // 防止单行情况
                for (i in right downTo left) {
                    matrix[bottom][i] = num++
                }
                bottom--
            }

            // 4. 从下到上填充左边界
            if (left <= right) {  // 防止单列情况
                for (i in bottom downTo top) {
                    matrix[i][left] = num++
                }
                left++
            }
        }

        return matrix
    }
}

fun main() {
    val solution59 = Solution59()
    solution59.generateMatrix(3).forEach { println(it.joinToString()) }.also { println() }
    solution59.generateMatrix(1).forEach { println(it.joinToString()) }.also { println() }
    solution59.generateMatrix(2).forEach { println(it.joinToString()) }.also { println() }
    solution59.generateMatrix(4).forEach { println(it.joinToString()) }.also { println() }
    solution59.generateMatrix(5).forEach { println(it.joinToString()) }.also { println() }
}
