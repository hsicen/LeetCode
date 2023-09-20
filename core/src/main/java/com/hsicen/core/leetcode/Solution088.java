package com.hsicen.core.leetcode;

/**
 * 作者：hsicen  2020/5/19 17:22
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Solution088 {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1, 1, nums2, 0);
        printArray(nums1);
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
                lenA++;
            } else {
                nums1[lenC++] = second;
                lenB++;
            }
        }

        while (lenA < m) {
            nums1[lenC++] = nums1[len - m + lenA];
            lenA++;
        }

        while (lenB < n) {
            nums1[lenC++] = nums2[lenB];
            lenB++;
        }
    }

    private static void printArray(int[] arr) {
        System.out.println("开始打印：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("结束打印");
    }
}
