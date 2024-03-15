package com.hsicen.core.string

/**
 * <p>作者：Night  2019/1/22 20:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：最长回文子串
 *
 * LeetCode第五题
 */

fun main() {

    val str = "12111"
    println("$str  的最长回文子串为：${longestPalindrome(str)}")
}

fun longestPalindrome(s: String): String {
    if (s.length < 2) return s
    var start = 0
    var end = 0

    (1..s.length / 2).forEach { first ->
        for (pos in 1..first) {
            if (first == 1) {
                if (s[first] == s[first - 1]) {
                    start = first - 1
                    end = first
                }
                return@forEach
            } else if (s[first - pos] == s[first + pos]) {
                start = first - pos
                end = first + pos
            } else if (s[first] == s[first - pos]) {
                start = first - pos
                end = first
            } else if (s[first] == s[first + pos]) {
                start = first
                end = first + pos
            } else break
        }
    }

    return s.substring(start, end + 1)
}