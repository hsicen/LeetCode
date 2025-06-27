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
        fun checkContain(sMap: HashMap<Char, Int>, tMap: HashMap<Char, Int>): Boolean {
            if (tMap.size > sMap.size) return false
            for ((tKey, tVal) in tMap) {
                val sVal = sMap[tKey] ?: 0
                if (sVal < tVal) {
                    return false
                }
            }

            return true
        }

        if (s.isEmpty() || t.isEmpty()) return ""

        // 记录符合要求的字串起始和结束位置
        var endIndex = -1
        var startIndex = 0
        var slowIndex = 0

        // 存储 s和t 中每个字符出现的次数
        val sMap = HashMap<Char, Int>()
        val tMap = HashMap<Char, Int>()

        for (char in t) {
            val count = tMap[char] ?: 0
            tMap[char] = count + 1
        }

        for (fastIndex in s.indices) {
            val char = s[fastIndex]
            val charCount = sMap[char] ?: 0
            sMap[char] = charCount + 1

            while (checkContain(sMap, tMap)) {
                if (endIndex != -1) { // 第二次进入
                    if (fastIndex - startIndex <= endIndex - slowIndex) {
                        endIndex = fastIndex
                        slowIndex = startIndex
                    }
                } else { // 第一次进入
                    endIndex = fastIndex
                    slowIndex = 0
                }

                // 开始移动起始窗口
                val startChar = s[startIndex]
                val startCharCount = (sMap[startChar] ?: 0) - 1
                if (startCharCount < 1) {
                    sMap.remove(startChar)
                } else {
                    sMap[startChar] = startCharCount
                }

                startIndex++
            }
        }

        return if (endIndex == -1) "" else s.substring(slowIndex, endIndex + 1)
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