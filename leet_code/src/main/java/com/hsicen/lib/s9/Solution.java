package com.hsicen.lib.s9;

/**
 * 作者：hsicen  2020/5/15 10:29
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * <p>
 * 思路：将数字转换成字符串，倒序字符串和原字符串对比
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("-121 :" + isPalindrome(-121));
        System.out.println("121 :" + isPalindrome(121));
        System.out.println("1122 :" + isPalindrome(1122));
        System.out.println("3223 :" + isPalindrome(3223));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        String origin = String.valueOf(x);
        int len = origin.length();

        for (int i = 0; i < len / 2; i++) {
            if (origin.charAt(i) != origin.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
