package com.hsicen.code.array

/**
 * @author: hsc
 * @date: 2025/6/27 18:21
 * @email: codinghuang@163.com
 * @description: LCR146.螺旋遍历二维数组
 * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果
 * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，
 * 然后再进入内部一层重复相同的步骤，直到提取完所有元素。
 *
 * 示例 1：
 * 输入：array = [[1,2,3],[8,9,4],[7,6,5]]
 * 输出：[1,2,3,4,5,6,7,8,9]
 *
 * 示例 2：
 * 输入：array = [[1,2,3,4],[8,9,10,5],[7,6,11,12]]
 * 输出：[1,2,3,4,5,6,7,8,9,10,11,12]
 */
object Solution146LCR {
    fun spiralArray(array: Array<IntArray>): IntArray {
        if (array.isEmpty()) return IntArray(0)

        val result = IntArray(array.size * array[0].size)
        var count = 0

        var top = 0
        var right = array[0].size - 1
        var bottom = array.size - 1
        var left = 0

        while (top <= bottom && left <= right) {
            // 1. 从左到右遍历上边界(top不变)
            for (i in left..right) {
                result[count++] = array[top][i]
            }
            top++

            // 2. 从上到下遍历右边界(right不变)
            for (i in top..bottom) {
                result[count++] = array[i][right]
            }
            right--

            // 3. 从右到左遍历下边界(bottom不变)
            if (top <= bottom) { // 保证还有行可遍历
                for (i in right downTo left) {
                    result[count++] = array[bottom][i]
                }
                bottom--
            }

            // 4. 从下到上遍历左边界(left不变)
            if (left <= right) { // 保证还有列可遍历
                for (i in bottom downTo top) {
                    result[count++] = array[i][left]
                }
                left++
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        println(spiralArray(array).joinToString())

        val array2 = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        println(spiralArray(array2).joinToString())

        val array3 = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25)
        )
        println(spiralArray(array3).joinToString())
    }
}