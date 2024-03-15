package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/15 17:34
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 * <p>
 * 思路：递归求解
 */
public class Solution038 {

    public static void main(String[] args) {

        System.out.println("1: " + countAndSay(1));
        System.out.println("2: " + countAndSay(2));
        System.out.println("3: " + countAndSay(3));
        System.out.println("4: " + countAndSay(4));
        System.out.println("5: " + countAndSay(5));
        System.out.println("6: " + countAndSay(6));
        System.out.println("7: " + countAndSay(7));
        System.out.println("8: " + countAndSay(8));
        System.out.println("9: " + countAndSay(9));
        System.out.println("10: " + countAndSay(10));
        System.out.println("29: " + countAndSay(29));
    }


    public static String countAndSay(int n) {
        if (1 == n) return "1";
        String sayStr = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        char tmp = sayStr.charAt(0);
        int count = 1;

        if (sayStr.length() > 1) {
            for (int i = 1; i < sayStr.length(); i++) {
                char c = sayStr.charAt(i);
                if (tmp == c) {
                    count++;
                } else {
                    sb.append(count).append(tmp);
                    tmp = c;
                    count = 1;
                }
            }

            sb.append(count).append(tmp);
        } else {
            sb.append(count).append(tmp);
        }

        return sb.toString();
    }
}
