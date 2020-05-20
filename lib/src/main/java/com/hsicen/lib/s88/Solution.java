package com.hsicen.lib.s88;

/**
 * 作者：hsicen  2020/5/19 17:22
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        merge(nums1, 5, nums2, 3);
        System.out.println("Result：" + nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int lenA = 0;
        int lenB = 0;
        int lenC = 0;

        for (int i = m - 1; i >= 0; i--) {
            nums1[len - (m - i)] = nums1[i];
        }

        while (lenA < m && lenB < n) {
            int first = nums1[len - m + lenA];
            int second = nums2[lenB];

            if (first <= second) {
                nums1[lenC++] = first;
                nums1[len - m + lenA] = 0;
                lenA++;
            } else {
                nums1[lenC++] = second;
                lenB++;
            }
        }

        while (lenA < m) {
            nums1[lenC++] = nums1[len - m + lenA];
            nums1[len - m + lenA] = 0;
            lenA++;
        }

        while (lenB < n) {
            nums1[lenC++] = nums2[lenB];
            lenB++;
        }
    }
}
