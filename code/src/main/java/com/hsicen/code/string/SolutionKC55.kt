package com.hsicen.code.string

/**
 * @author: hsc
 * @date: 2025/10/22 16:44
 * @email: codinghuang@163.com
 * @description: 55.右旋转字符串
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 *
 * 输入描述
 * 输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
 *
 * 输出描述
 * 输出共一行，为进行了右旋转操作后的字符串。
 *
 * 示例
 * 输入
 * 2
 * abcdefg
 *
 * 输出
 * fgabcde
 */
object SolutionKC55 {
    // 不使用额外空间，采取3次反转，完成操作
    // 时间复杂度O(n) 空间复杂度O(1)
    fun rotateString(s: String, k: Int): String {
        val chars = s.toCharArray()
        val len = chars.size

        // 反转顺序不同，可以实现不同的旋转算法
        reverse(chars, 0, len - 1)
        reverse(chars, 0, k - 1)
        reverse(chars, k, len - 1)

        return chars.joinToString("")
    }

    private fun reverse(chars: CharArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(rotateString("abcdefg", 2))
    }
}