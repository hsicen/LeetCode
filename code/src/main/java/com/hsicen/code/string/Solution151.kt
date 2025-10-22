package com.hsicen.code.string

/**
 * @author: hsc
 * @date: 2025/8/8 11:14
 * @email: codinghuang@163.com
 * @description: 151.反转字符串中的单词
 * 給你一個字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 * 输入：s = " hello world "
 * 输出："world hello"
 *
 * 示例 3：
 * 输入：s = "a good  example"
 * 输出："example good a"
 */
object Solution151 {

    // 使用内置函数，代码最简洁
    fun reverseWords1(s: String): String {
        return s.trim().split("\\s+".toRegex()).reversed().joinToString(" ")
    }

    // 双端队列，平衡效率与可读性
    fun reverseWords2(s: String): String {
        val words = ArrayDeque<String>()
        val sb = StringBuilder()

        for (c in s) {
            if (c == ' ') {
                if (sb.isNotEmpty()) {
                    words.addFirst(sb.toString())
                    sb.clear()
                }
            } else {
                sb.append(c)
            }
        }

        if (sb.isNotEmpty()) words.addFirst(sb.toString())
        return words.joinToString(" ")
    }

    // 最优空间求解
    fun reverseWords(s: String): String {
        // 将字符串转换为字符数组，方便操作
        val chars = s.toCharArray()

        // 1. 去除多余空格(快慢指针法)
        val trimmedLength = trimExtraSpaces(chars)

        // 2. 反转整个字符串
        reverse(chars, 0, trimmedLength - 1)

        // 3. 反转每个单词
        reverseEachWord(chars, trimmedLength)

        return String(chars, 0, trimmedLength)
    }

    private fun trimExtraSpaces(chars: CharArray): Int {
        var slow = 0
        var fast = 0

        while (fast < chars.size) {
            if (chars[fast] != ' ') {
                // 单词之间保留一个空格
                if (slow != 0) {
                    chars[slow++] = ' '
                }
                // 复制完整单词
                var j = fast
                while (j < chars.size && chars[j] != ' ') {
                    chars[slow++] = chars[j++]
                }
                fast = j
            } else {
                fast++
            }
        }
        return slow
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

    private fun reverseEachWord(chars: CharArray, length: Int) {
        var start = 0
        for (end in 0 until length) {
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1)
                start = end + 1
            }
        }

        reverse(chars, start, length - 1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(reverseWords("the sky is blue"))
        println(reverseWords(" hello world "))
        println(reverseWords("a good  example"))
    }
}