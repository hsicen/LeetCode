package com.hsicen.lib.s135;

/**
 * 作者：hsicen  2020/5/14 16:38
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：分糖果
 */
class Main {

    public static void main(String[] args) {

        System.out.println("result：" + candy(new int[]{1, 2, 1}));
        System.out.println("result：" + candy(new int[]{4, 5, 5}));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        if (1 >= len) return len;

        int[] sugars = new int[len];
        for (int i = 0; i < len; i++) {
            sugars[i] = 1;
        }

        //从左到右遍历
        for (int i = 1; i < len; i++) {
            int left = ratings[i - 1];
            int right = ratings[i];

            if (left > right) {
                sugars[i - 1] = sugars[i] + 1;
            } else if (right > left) {
                sugars[i] = sugars[i - 1] + 1;
            }
        }

        //从右向左遍历
        for (int i = len - 1; i > 0; i--) {
            int right = ratings[i];
            int left = ratings[i - 1];

            if (left > right) {
                sugars[i - 1] = sugars[i] + 1;
            } else if (right > left) {
                sugars[i] = sugars[i - 1] + 1;
            }
        }

        //数组求和
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += sugars[i];
        }

        return count;
    }
}
