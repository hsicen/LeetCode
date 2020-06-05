package com.hsicen.lib.s135;

/**
 * 作者：hsicen  2020/5/14 16:38
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：分糖果
 */
class Solution {

    public static void main(String[] args) {

        System.out.println("result：" + candy(new int[]{1, 0, 2}));
        System.out.println("result：" + candy(new int[]{1, 2, 1}));
        System.out.println("result：" + candy(new int[]{4, 5, 5}));
        System.out.println("result：" + candy(new int[]{1, 6, 10, 8, 7, 3, 2}));
    }

    public static int candy(int[] ratings) {
        if (null == ratings || 0 == ratings.length) return 0;
        if (1 == ratings.length) return 1;

        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
        }

        int count = len;
        for (int i = 0; i < len; i++) {
            count += Math.max(left[i], right[i]);
        }

        return count;
    }
}
