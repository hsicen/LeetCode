package com.hsicen.code.string

/**
 * <p>作者：Night  2019/1/22 20:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：最长回文子串
 *
 * LeetCode第五题
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 */

fun main() {
    val testCases = arrayOf(
        "babad",
        "cbbd",
        "12111",
        "racecar",
        "abcdef",
        "aa",
        "a",
        ""
    )
    
    testCases.forEach { str ->
        println("\"$str\" 的最长回文子串为：\"${longestPalindrome(str)}\"")
        println("优化版本结果：\"${longestPalindromeOptimized(str)}\"")
        println("动态规划结果：\"${longestPalindromeDP(str)}\"")
        println()
    }
}

/**
 * 中心扩展法 - 简单版本
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""
    if (s.length == 1) return s
    
    var start = 0
    var maxLen = 1
    
    for (i in s.indices) {
        // 检查奇数长度回文串（以i为中心）
        val len1 = expandAroundCenter(s, i, i)
        // 检查偶数长度回文串（以i和i+1为中心）
        val len2 = expandAroundCenter(s, i, i + 1)
        
        val currentMaxLen = maxOf(len1, len2)
        if (currentMaxLen > maxLen) {
            maxLen = currentMaxLen
            start = i - (currentMaxLen - 1) / 2
        }
    }
    
    return s.substring(start, start + maxLen)
}

/**
 * 中心扩展辅助函数
 */
private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    
    return r - l - 1
}

/**
 * 中心扩展法 - 优化版本
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
fun longestPalindromeOptimized(s: String): String {
    if (s.isEmpty()) return ""
    if (s.length == 1) return s
    
    var start = 0
    var end = 0
    
    for (i in s.indices) {
        val len1 = expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i + 1)
        val len = maxOf(len1, len2)
        
        if (len > end - start) {
            start = i - (len - 1) / 2
            end = i + len / 2
        }
    }
    
    return s.substring(start, end + 1)
}

/**
 * 动态规划解法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
fun longestPalindromeDP(s: String): String {
    if (s.isEmpty()) return ""
    if (s.length == 1) return s
    
    val n = s.length
    val dp = Array(n) { BooleanArray(n) }
    var start = 0
    var maxLen = 1
    
    // 所有单个字符都是回文串
    for (i in 0 until n) {
        dp[i][i] = true
    }
    
    // 检查长度为2的子串
    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            maxLen = 2
        }
    }
    
    // 检查长度大于2的子串
    for (len in 3..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                start = i
                maxLen = len
            }
        }
    }
    
    return s.substring(start, start + maxLen)
}

/**
 * Manacher算法 - 最优解法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
fun longestPalindromeManacher(s: String): String {
    if (s.isEmpty()) return ""
    
    // 预处理字符串，在每个字符之间插入#
    val processed = StringBuilder()
    processed.append('^')
    for (char in s) {
        processed.append('#').append(char)
    }
    processed.append('#').append('$')
    
    val n = processed.length
    val p = IntArray(n)
    var center = 0
    var right = 0
    var maxLen = 0
    var centerIndex = 0
    
    for (i in 1 until n - 1) {
        val mirror = 2 * center - i
        
        if (i < right) {
            p[i] = minOf(right - i, p[mirror])
        }
        
        // 尝试扩展回文串
        while (processed[i + p[i] + 1] == processed[i - p[i] - 1]) {
            p[i]++
        }
        
        // 如果回文串扩展超过了right，则调整center和right
        if (i + p[i] > right) {
            center = i
            right = i + p[i]
        }
        
        // 更新最长回文串的信息
        if (p[i] > maxLen) {
            maxLen = p[i]
            centerIndex = i
        }
    }
    
    // 计算原始字符串中的起始位置
    val start = (centerIndex - maxLen) / 2
    return s.substring(start, start + maxLen)
}