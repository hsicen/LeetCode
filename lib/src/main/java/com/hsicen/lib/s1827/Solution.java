package com.hsicen.lib.s1827;

/**
 * 作者：hsicen  2020/6/3 14:56
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：1287. 有序数组中出现次数超过25%的元素
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
class Solution {

    public static void main(String[] args) {

    }

    public int findSpecialInteger(int[] arr) {
        if (null == arr || 0 == arr.length) return -1;
        if (2 >= arr.length) return arr[0];

        int tmp = arr[0];
        int count = 1;
        double aimCount = arr.length * 0.25;

        for (int i = 1; i < arr.length; i++) {
            if (tmp == arr[i]) {
                count++;
                if (count > arr.length * 0.25) return tmp;
            } else {
                tmp = arr[i];
                count = 1;
            }
        }

        return tmp;
    }

    public int findSpecialInteger2(int[] arr) {
        if (null == arr || 0 == arr.length) return -1;
        if (2 >= arr.length) return arr[0];

        for (int i = 1, len = arr.length / 4; i < arr.length - len; i++) {
            if (arr[i] == arr[i + len]) {
                return arr[i];
            }
        }

        return arr[0];
    }
}
