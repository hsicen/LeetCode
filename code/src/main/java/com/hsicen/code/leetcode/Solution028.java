package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/15 14:31
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：字符串匹配
 * <a href="https://leetcode-cn.com/problems/implement-strstr/">...</a>
 * <p>
 * 思路：从haystack字符串中找出needle第一次出现的位置
 */
public class Solution028 {

    public static void main(String[] args) {

        System.out.println("Index is：" + strStr("hello", "ll"));
        System.out.println("Index is：" + strStr("aaaaa", "bba"));
        System.out.println("Index is：" + strStr("aaacaaab", "aaab"));
        System.out.println("Index is：" + strStr("a", "a"));
        System.out.println("Index is：" + strStr("mississippi", "pi"));
    }

    public static int strStr(String haystack, String needle) {
        if (null == needle || needle.isEmpty()) return 0;
        if (null == haystack || haystack.isEmpty()
                || needle.length() > haystack.length())
            return -1;
        if (haystack.equals(needle)) return 0;

        int size = needle.length();
        for (int i = 0; i <= haystack.length() - size; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + size).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}

