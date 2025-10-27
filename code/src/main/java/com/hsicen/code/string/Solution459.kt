package com.hsicen.code.string

/**
 * @author: hsicen
 * @date: 2025/10/27 15:51
 * @email: codinghuang@163.com
 * @description: 459.重复的子字符串
 * 给定一个非空字符串 s，判断它是否可以由它的一个子串重复多次构成。
 *
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子字符串 "ab" 重复两次构成
 *
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子字符串 "abc" 重复四次构成
 */
object Solution459 {

    /**
     * 解法一：KMP算法（最优解）
     * 核心思想：利用Next数组（前缀表）的性质
     *
     * 如果字符串由重复子串构成，则：
     * 1. 最长相等前后缀的长度 next[len-1] 会指向重复模式的边界
     * 2. 最小重复子串长度 = len - next[len-1]
     * 3. 如果 len % (len - next[len-1]) == 0，说明可以整除，即由重复子串构成
     *
     * 例如："abababab" (长度8)
     * Next数组: [0,0,1,2,3,4,5,6]
     * next[7] = 6，表示最长相等前后缀长度为6
     * 最小重复子串长度 = 8 - 6 = 2 ("ab")
     * 8 % 2 = 0，所以返回true
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    fun repeatedSubstringPattern(s: String): Boolean {
        if (s.length < 2) return false

        // 构建Next数组
        val next = getNext(s)
        val len = s.length

        // next[len-1] 表示整个字符串的最长相等前后缀长度
        // 如果存在重复子串，且 len % (len - next[len-1]) == 0，则返回true
        return next[len - 1] > 0 && len % (len - next[len - 1]) == 0
    }

    /**
     * 构建Next数组（前缀表）
     */
    private fun getNext(s: String): IntArray {
        val next = IntArray(s.length)
        var j = 0

        for (i in 1 until s.length) {
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1]
            }

            if (s[i] == s[j]) {
                j++
            }

            next[i] = j
        }

        return next
    }

    /**
     * 解法二：字符串拼接法
     * 核心思想：如果s由重复子串构成，那么s会在(s+s)的中间部分出现
     *
     * 例如：s = "abab"
     * s + s = "abababab"
     * 去掉首尾：" bababab" -> "bababa "
     * 在中间能找到"abab"，返回true
     *
     * 时间复杂度：O(n)，取决于indexOf的实现
     * 空间复杂度：O(n)
     */
    fun repeatedSubstringPattern2(s: String): Boolean {
        val doubled = s + s
        // 去掉首尾字符，避免匹配到原位置
        return doubled.substring(1, doubled.length - 1).contains(s)
    }

    /**
     * 解法三：枚举法
     * 枚举所有可能的子串长度（必须是字符串长度的因数）
     *
     * 时间复杂度：O(n * sqrt(n))
     * 空间复杂度：O(1)
     */
    fun repeatedSubstringPattern3(s: String): Boolean {
        val len = s.length

        // 子串长度必须是总长度的因数，且至少重复2次
        for (subLen in 1..len / 2) {
            if (len % subLen == 0) {
                // 检查是否由长度为subLen的子串重复构成
                var isRepeated = true
                for (i in subLen until len) {
                    if (s[i] != s[i % subLen]) {
                        isRepeated = false
                        break
                    }
                }
                if (isRepeated) return true
            }
        }

        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // 测试用例
        println("KMP解法：")
        println(repeatedSubstringPattern("abab"))          // true
        println(repeatedSubstringPattern("aba"))           // false
        println(repeatedSubstringPattern("abcabcabcabc"))  // true
        println(repeatedSubstringPattern("aabaaba"))       // false
        println(repeatedSubstringPattern("aaa"))           // true

        println("\n字符串拼接法：")
        println(repeatedSubstringPattern2("abab"))         // true
        println(repeatedSubstringPattern2("aba"))          // false

        println("\n枚举法：")
        println(repeatedSubstringPattern3("abab"))         // true
        println(repeatedSubstringPattern3("aba"))          // false
    }
}