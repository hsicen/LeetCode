package com.hsicen.core.string;

/**
 * <p>作者：Hsicen  2019/8/26 21:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：链表
 * <p>描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 使用两个指针 从两端向中间进行比较
     */
    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;

            if (s.toLowerCase().charAt(start) != s.toLowerCase().charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
