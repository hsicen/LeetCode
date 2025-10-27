package com.hsicen.code.string

/**
 * @author: hsicen
 * @date: 2025/10/24 16:01
 * @email: codinghuang@163.com
 * @description: 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配，第一个匹配项的下标是 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
object Solution28 {

    /**
     * KMP算法核心：
     * 【1】Next数组（前缀表）：
     *  （1）记录模式串下标i(包含i)之前的字符串的最长相同前后缀的长度
     *  （2）前缀：以第一个字符开头，不包含最后一个字符的连续子串
     *  （3）后缀：以最后一个字符结尾，不包含第一个字符的连续子串
     * 【2】字符串匹配：
     *  （1）当文本串与模式串字符不匹配时，利用Next数组快速移动模式串
     *  （2）避免重复比较已经匹配过的字符
     *
     * 时间复杂度：O(n + m)，n为文本串长度，m为模式串长度
     * 空间复杂度：O(m)
     */
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.length < needle.length) return -1

        // 构建Next数组
        val next = getNext(needle)

        // KMP匹配
        var j = 0  // j指向模式串needle的当前匹配位置
        for (i in haystack.indices) {  // i指向文本串haystack的当前位置
            // 不匹配时，根据Next数组回退j
            while (j > 0 && haystack[i] != needle[j]) {
                j = next[j - 1]
            }

            // 匹配成功，j后移
            if (haystack[i] == needle[j]) {
                j++
            }

            // 完全匹配，返回起始位置
            if (j == needle.length) {
                return i - needle.length + 1
            }
        }

        return -1
    }

    /**
     * 构建Next数组（前缀表）
     * next[i] 表示 pattern[0...i] 中最长相等前后缀的长度
     *
     * 示例：pattern = "aabaaf"
     * 索引：  0  1  2  3  4  5
     * 字符：  a  a  b  a  a  f
     * Next： 0  1  0  1  2  0
     */
    private fun getNext(pattern: String): IntArray {
        val next = IntArray(pattern.length)
        var j = 0  // j指向前缀末尾，同时表示最长相等前后缀的长度

        // i指向后缀末尾，从1开始（单个字符没有前后缀）
        for (i in 1 until pattern.length) {
            // 前后缀不匹配，j回退到上一个可能匹配的位置
            while (j > 0 && pattern[i] != pattern[j]) {
                j = next[j - 1]
            }

            // 前后缀匹配，前缀长度+1
            if (pattern[i] == pattern[j]) {
                j++
            }

            next[i] = j
        }

        return next
    }


    @JvmStatic
    fun main(args: Array<String>) {
        println(strStr("sadbutsad", "sad"))
        println(strStr("leetcode", "leeto"))
    }
}