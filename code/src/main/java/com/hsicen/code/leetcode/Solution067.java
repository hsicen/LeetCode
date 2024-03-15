package com.hsicen.code.leetcode;


import java.util.Stack;

/**
 * 作者：hsicen  2020/5/18 10:39
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：二进制数相加
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * 思路：利用两个栈来相加
 */
public class Solution067 {

    public static void main(String[] args) {
        System.out.println("Result：" + addBinary2("1101", "1001"));
        System.out.println("Result：" + addBinary2("1101", "101"));
        System.out.println("Result：" + addBinary2("0", "0"));
        System.out.println("Result：" + addBinary2("0", "1"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;

        for (int indexA = a.length() - 1, indexB = b.length() - 1;
             indexA >= 0 || indexB >= 0; indexA--, indexB--) {
            int sum = ca;
            sum += (indexA < 0) ? 0 : a.charAt(indexA) - '0';
            sum += (indexB < 0) ? 0 : b.charAt(indexB) - '0';

            sb.append(sum % 2);
            ca = sum / 2;
        }

        if (ca > 0) sb.append('1');

        return sb.reverse().toString();
    }

    public static String addBinary3(String a, String b) {
        if (a.equals(b) && a.equals("0")) return "0";
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;

        char charA, charB;
        boolean flag = false;
        int len = Math.max(lenA, lenB);
        char[] result = new char[len + 2];

        for (int i = 0; i <= len; i++) {
            int indexA = lenA - i;
            int indexB = lenB - i;
            int index = len + 1 - i;

            if (indexA < 0) {
                charA = '0';
            } else charA = a.charAt(indexA);

            if (indexB < 0) {
                charB = '0';
            } else charB = b.charAt(indexB);

            //对应位相加
            if (charA == charB && charA == '1') {
                if (flag) result[index] = '1';
                else result[index] = '0';
                flag = true;
            } else if (charA == charB && charA == '0') {
                if (flag) result[index] = '1';
                else result[index] = '0';
                flag = false;
            } else {
                if (flag) {
                    result[index] = '0';
                    flag = true;
                } else {
                    result[index] = '1';
                    flag = false;
                }
            }
        }

        String tmp;
        if (flag) {
            result[0] = '1';
            tmp = new String(result);
        } else {
            tmp = new String(result, 1, len + 1);
        }

        return tmp;
    }

    public static String addBinary2(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        char charA, charB;
        boolean flag = false;
        int len = Math.max(lenA, lenB);

        StringBuilder sb = new StringBuilder(len + 2);
        for (int i = 0; i <= len; i++) {
            int indexA = lenA - i;
            int indexB = lenB - i;

            //获取字符
            if (indexA < 0) {
                charA = '0';
            } else charA = a.charAt(indexA);

            if (indexB < 0) {
                charB = '0';
            } else charB = b.charAt(indexB);

            //对应位相加
            if (charA == charB && charA == '1') {
                if (flag) sb.append('1');
                else sb.append('0');
                flag = true;
            } else if (charA == charB && charA == '0') {
                if (flag) sb.append('1');
                else sb.append('0');
                flag = false;
            } else {
                if (flag) {
                    sb.append('0');
                    flag = true;
                } else {
                    sb.append('1');
                    flag = false;
                }
            }
        }

        if (flag) sb.append('1');

        return sb.reverse().toString();
    }

    public static String addBinary1(String a, String b) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        Stack<Character> stackC = new Stack<>();
        int len = Math.max(a.length(), b.length());
        boolean flag = false;

        for (int i = 0; i < a.length(); i++) {
            stackA.push(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            stackB.push(b.charAt(i));
        }

        for (int i = 0; i < len; i++) {
            Character ba = null;
            try {
                ba = stackA.pop();
            } catch (Exception e) {
                ba = '0';
            }

            Character bb = null;
            try {
                bb = stackB.pop();
            } catch (Exception e) {
                bb = '0';
            }

            if (ba == bb && ba == '1') {
                if (flag) stackC.push('1');
                else stackC.push('0');
                flag = true;
            } else if (ba == bb && ba == '0') {
                if (flag) stackC.push('1');
                else stackC.push('0');
                flag = false;
            } else {
                if (flag) {
                    stackC.push('0');
                    flag = true;
                } else {
                    stackC.push('1');
                    flag = false;
                }
            }
        }

        if (flag) stackC.push('1');

        return stackC.toString();
    }
}
