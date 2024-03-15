package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/15 11:47
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 思路：找数组中长度最短的进行比较，看是否有公共前缀
 */
public class Solution014 {

    public static void main(String[] args) {
        System.out.println("The result：" + longestCommonPrefix(new String[]{"aaa", "aaaa", "a"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        //找出长度最小数组
        int len = strs[0].length();
        for (String str : strs) {
            if (str.length() < len) len = str.length();
        }

        StringBuilder prefix = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int item = 1; item < strs.length; item++) {
                char tmp = strs[item].charAt(i);
                if (c != tmp) return prefix.toString();
            }

            prefix.append(c);
        }

        return prefix.toString();
    }
}
