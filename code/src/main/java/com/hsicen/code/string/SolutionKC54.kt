package com.hsicen.code.string

import java.util.Scanner

/**
 * @author: hsc
 * @date: 2025/8/7 18:24
 * @email: codinghuang@163.com
 * @description: 54.替换数字
 * 给定一个字符串 s，它包含小写字母和数字字符，
 * 请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 *
 * 输入一个字符串 s,s 仅包含小写字母和数字字符。
 * 打印一个新的字符串，其中每个数字字符都被替换为了number
 *
 * 示例：
 * 输入：s = "a1b2c3"
 * 输出："anumberbnumbercnumber"
 *
 * 提示：
 * 1 <= s.length <= 100
 */
object SolutionKC54 {
    fun replaceDigits(s: String): String {
        // 统计数字的个数
        var count = 0
        val chars = s.toCharArray()
        for (c in chars) {
            if (c.isDigit()) {
                count++
            }
        }

        // 如果没有数字，直接返回原字符串
        if (count == 0) return s

        // 计算新字符串的长度：原长度 + 数字个数 * ("number"长度 - 1)
        val newLength = chars.size + count * 5
        val result = CharArray(newLength)

        // 双指针从后往前填充
        var left = chars.size - 1   // 原字符串指针
        var right = newLength - 1   // 新字符串指针

        while (left >= 0) {
            if (chars[left].isDigit()) {
                // 如果是数字，替换为"number"
                for (i in "number".length - 1 downTo 0) {
                    result[right--] = "number"[i]
                }
            } else {
                // 如果不是数字，直接复制
                result[right--] = chars[left]
            }
            left--
        }

        return String(result)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNextLine()) {
            val s = scanner.nextLine()
            println(replaceDigits(s))
        }

        scanner.close()
    }
}
