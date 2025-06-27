package com.hsicen.code.array


/**
 * @author: hsc
 * @date: 2025/6/24 17:56
 * @email: codinghuang@163.com
 * @description: 76.最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例1:
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 。
 *
 * 示例2:
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例3:
 * 输入：s = "a", t = "aa"
 * 输出：""
 * 解释：因为字符串 t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此，没有符合条件的子字符串，返回空字符串。
 */
class Solution76 {

    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty() || s.length < t.length) return ""

        val counts = IntArray(128)
        var keys = 0

        t.forEach { c ->
            if (counts[c.code] == 0) keys++
            counts[c.code]++
        }

        var left = 0
        var minLen = Int.MAX_VALUE
        var start = 0

        for (right in s.indices) {
            val c = s[right].code
            counts[c]--
            if (counts[c] == 0) keys--

            while (keys == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1
                    start = left
                }
                val leftChar = s[left].code
                if (counts[leftChar] == 0) keys++
                counts[leftChar]++
                left++
            }
        }

        return if (minLen == Int.MAX_VALUE) "" else s.substring(start, start + minLen)
    }
}

fun main() {
    val solution = Solution76()

    val s = "ADOBECODEBANC"
    val t = "ABC"
    val result = solution.minWindow(s, t)
    println("最小覆盖子串：$result")

    val s2 = "a"
    val t2 = "a"
    val result2 = solution.minWindow(s2, t2)
    println("最小覆盖子串：$result2")

    val s3 = "cabwefgewcwaefgcf"
    val t3 = "cae"
    val result3 = solution.minWindow(s3, t3)
    println("最小覆盖子串：$result3")

    val s4 = "a"
    val t4 = "aa"
    val result4 = solution.minWindow(s4, t4)
    println("最小覆盖子串：$result4")

    val s5 = "ab"
    val t5 = "b"
    val result5 = solution.minWindow(s5, t5)
    println("最小覆盖子串：$result5")

    val s6 = "aaabdabcefaecbef"
    val t6 = "abc" // aecb
    val result6 = solution.minWindow(s6, t6)
    println("最小覆盖子串：$result6")
}