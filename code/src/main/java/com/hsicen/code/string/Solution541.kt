package com.hsicen.code.string

/**
 * @author: hsc
 * @date: 2025/8/7 16:41
 * @email: codinghuang@163.com
 * @description: 541.反转字符串2
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *     如果剩余字符少于 k 个，则将剩余字符全部反转。
 *     如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
object Solution541 {

    fun reverseStr(s: String, k: Int): String {
        val chars = s.toCharArray()
        var i = 0
        while (i < chars.size) {
            // 计算需要反转的结束位置
            val end = minOf(i + k - 1, chars.size - 1)

            // 手动实现反转逻辑，避免函数调用开销
            var left = i
            var right = end
            while (left < right) {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp
                left++
                right--
            }

            // 移动到下一个 2k 区间
            i += 2 * k
        }

        return String(chars)
    }


    @JvmStatic
    fun main(args: Array<String>) {
        println(reverseStr("abcdefg", 2))
        println(reverseStr("abcd", 2))
    }
}
