package com.hsicen.lib.s13;

/**
 * 作者：hsicen  2020/5/15 10:48
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * <p>
 * 思路：将罗马数字和对应的数值映射，先加上所有的值，然后再进去特殊情况多加的
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println("III：" + romanToInt("III"));
        System.out.println("IV：" + romanToInt("IV"));
        System.out.println("VII：" + romanToInt("VII"));
        System.out.println("MCMXCIV：" + romanToInt("MCMXCIV"));
        System.out.println("VVVVV：" + romanToInt("VVVVV"));
        System.out.println("IIIIIV：" + romanToInt("IIIIIV"));
    }

    public static int romanToInt(String s) {
        int romanInt = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            switch (tmp) {
                case 'I':
                    romanInt += 1;
                    break;
                case 'V':
                    romanInt += 5;
                    break;
                case 'X':
                    romanInt += 10;
                    break;
                case 'L':
                    romanInt += 50;
                    break;
                case 'C':
                    romanInt += 100;
                    break;
                case 'D':
                    romanInt += 500;
                    break;
                case 'M':
                    romanInt += 1000;
                    break;
            }
        }

        //减去多加的
        for (int i = 1; i < len; i++) {
            char left = s.charAt(i - 1);
            char right = s.charAt(i);

            if ('I' == left && ('V' == right || 'X' == right)) {
                romanInt -= 2;
            } else if ('X' == left && ('L' == right || 'C' == right)) {
                romanInt -= 20;
            } else if ('C' == left && ('D' == right || 'M' == right)) {
                romanInt -= 200;
            }
        }

        return romanInt;
    }

}
