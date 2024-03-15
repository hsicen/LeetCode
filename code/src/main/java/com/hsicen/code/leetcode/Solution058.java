package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/18 8:56
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class Solution058 {

    public static void main(String[] args) {
        System.out.println("Result：" + lengthOfLastWord("a "));
        System.out.println("Result：" + lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        if (null == s || s.isEmpty()) return 0;
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                count++;
            } else {
                if (0 != count) return count;
            }
        }

        return count;
    }

}
