package com.hsicen.lib.s7;

/**
 * 作者：hsicen  2020/8/19 8:30
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * https://leetcode-cn.com/problems/reverse-integer/
 * 输入: 123
 * 输出: 321
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }

    //字符串反转
    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        String str = sb.reverse().toString();

        int result;

        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            result = 0;
        }

        return x > 0 ? result : -result;
    }

    //逐位取模
    public static int reverse1(int x) {
        long n = 0;

        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (int) n == n ? (int) n : 0;
    }

}
