package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/27 17:36
 * @email: codinghuang@163.com
 * @description: 54.螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
object Solution54 {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) return emptyList()

        val result = mutableListOf<Int>()
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {
            // 1.从左到右遍历上边界(top不变)
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++

            // 2.从上到下遍历右边界(right不变)
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right--

            // 3.从右到左遍历下边界(bottom不变)
            if (top <= bottom) {
                for (i in right downTo left) {
                    result.add(matrix[bottom][i])
                }
                bottom--
            }

            // 4.从下到上遍历左边界(left不变)
            if (left <= right) {
                for (i in bottom downTo top) {
                    result.add(matrix[i][left])
                }
                left++
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        println(spiralOrder(matrix))

        val matrix2 = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        println(spiralOrder(matrix2))

        val matrix3 = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20)
        )
        println(spiralOrder(matrix3))

        val matrix4 = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(7, 8, 9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16, 17, 18),
            intArrayOf(19, 20, 21, 22, 23, 24),
            intArrayOf(25, 26, 27, 28, 29, 30)
        )
        println(spiralOrder(matrix4))
    }
}
