package com.hsicen.core.array;

/**
 * <p>作者：Hsicen  2019/8/23 9:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：InterView
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * 思路：由于数组是有序数组，故数组平方的最大值一定在数组的两端产生，
 * 则可以从数组的两端往中间比较，得出最大的值由新数组的末尾往头开始添加
 */
public class LeetCode977 {

    public static void main(String[] args) {
        int[] sample = {-9, -5, -4, 0, 1, 4, 5, 8};
        sample = sortedSquares(sample);
        for (int i : sample) {
            System.out.print(i + "  ");
        }
    }

    private static int[] sortedSquares(int[] A) {
        int size = A.length;
        int[] result = new int[size];

        int start = 0;
        int end = size - 1;

        for (int i = size - 1; i > 0; i--) {
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                result[i] = A[start] * A[start];
                start++;
            } else {
                result[i] = A[end] * A[end];
                end--;
            }
        }

        return result;
    }

}
