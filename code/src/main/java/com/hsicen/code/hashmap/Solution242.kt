package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/7/14 15:24
 * @email: codinghuang@163.com
 * @description: 242.有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
object Solution242 {

    fun isAnagram(s: String, t: String): Boolean {
        HashMap<Char, Int>().apply {
            s.forEach {
                put(it, getOrDefault(it, 0) + 1)
            }

            t.forEach {
                put(it, getOrDefault(it, 0) - 1)
            }
            return values.all { it == 0 }
        }
    }


    fun isAnagram2(s: String, t: String): Boolean {
        val map = IntArray(26)
        s.toCharArray().forEach { map[it - 'a'] += 1 }
        t.toCharArray().forEach { map[it - 'a'] -= 1 }

        return map.all { it == 0 }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val s = "anagram"
        val t = "nagaram"
        println("$s $t isAnagram=${isAnagram2(s, t)}")

        val s1 = "rat"
        val t1 = "car"
        println("$s1 $t1 isAnagram=${isAnagram2(s1, t1)}")
    }
}