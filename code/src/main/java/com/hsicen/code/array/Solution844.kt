package com.hsicen.code.array

import java.util.Stack

/**
 * @author: hsc
 * @date: 2025/6/17 20:04
 * @email: codinghuang@163.com
 * @description: 844.比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 *
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 *
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 */
class Solution844 {
    fun backspaceCompare(s: String, t: String): Boolean {
        // 利用快慢指针，拿到最终字符串
        fun backStr(str: String): String {
            if (str.isEmpty()) return ""

            val strArr = str.toCharArray()
            var slow = 0
            for (fast in strArr.indices) {
                if (strArr[fast] != '#') {
                    strArr[slow++] = strArr[fast]
                } else {
                    slow--
                }
            }

            return String(strArr, 0, slow)
        }

        return backStr(s) == backStr(t)
    }

    // 使用栈的方式求解
    fun backspaceCompare2(s: String, t: String): Boolean {
        // 利用栈的方式求解
        fun backStr(str: String): String {
            if (str.isEmpty()) return ""
            var stack = Stack<Char>()

            for (c in str) {
                if (c == '#') {
                    if (stack.isNotEmpty()) {
                        stack.pop()
                    }
                } else {
                    stack.push(c)
                }
            }

            return stack.joinToString("")
        }

        return backStr(s) == backStr(t)
    }
}

fun main() {
    val solution = Solution844()
    println(solution.backspaceCompare2("ab#c", "ad#c"))
    println(solution.backspaceCompare2("ab##", "c#d#"))
    println(solution.backspaceCompare2("a#c", "b"))
}