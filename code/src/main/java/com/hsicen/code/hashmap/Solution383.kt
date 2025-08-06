package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/8/6 15:36
 * @email: codinghuang@163.com
 * @description: 383.赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 最优算法：哈希表计数法
 * 时间复杂度：O(m + n)，其中 m 是 ransomNote 的长度，n 是 magazine 的长度
 * 空间复杂度：O(k)，其中 k 是 magazine 中不同字符的个数
 */
object Solution383 {

    /**
     * 判断 ransomNote 是否能由 magazine 构成
     * @param ransomNote 需要构造的字符串
     * @param magazine 提供字符的字符串
     * @return 如果能构造返回 true，否则返回 false
     */
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        // 优化1: 如果ransomNote长度大于magazine，直接返回false
        if (ransomNote.length > magazine.length) {
            return false
        }

        // 优化2: 使用IntArray替代HashMap，提高访问效率
        val charCount = IntArray(26) // 假设只包含小写字母

        // 统计magazine中各字符出现次数
        for (char in magazine) {
            charCount[char - 'a']++
        }

        // 遍历ransomNote，检查是否能用magazine中的字符构造
        for (char in ransomNote) {
            // 如果当前字符在magazine中不存在或已用完，则无法构造
            if (charCount[char - 'a'] <= 0) {
                return false
            }
            // 使用一个字符，对应计数减一
            charCount[char - 'a']--
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val ransomNote = "aa"
        val magazine = "aab"
        println(canConstruct(ransomNote, magazine))

        val ransomNote2 = "aa"
        val magazine2 = "ab"
        println(canConstruct(ransomNote2, magazine2))

        val ransomNote3 = "a"
        val magazine3 = "b"
        println(canConstruct(ransomNote3, magazine3))
    }
}