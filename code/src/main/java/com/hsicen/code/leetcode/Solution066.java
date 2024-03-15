package com.hsicen.core.leetcode;

import java.util.Arrays;

/**
 * 作者：hsicen  2020/5/18 9:17
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：数组表示的数加1
 * <a href="https://leetcode-cn.com/problems/plus-one/">...</a>
 */
public class Solution066 {

    public static void main(String[] args) {
        System.out.println("Result：" + Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println("Result：" + Arrays.toString(plusOne(new int[]{4, 4, 9})));
        System.out.println("Result：" + Arrays.toString(plusOne(new int[]{9})));
        System.out.println("Result：" + Arrays.toString(plusOne(new int[]{1})));
        System.out.println("Result：" + Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        if (0 == digits.length) return digits;

        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        //跳出循环，全部是9
        int[] tmp = new int[len + 1];
        tmp[0] = 1;

        return tmp;
    }
}
