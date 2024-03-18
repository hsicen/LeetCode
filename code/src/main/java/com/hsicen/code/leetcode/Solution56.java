package com.hsicen.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: hsc
 * @date: 2024/3/18 15:54
 * @email: codinghuang@163.com
 * @description: 56.Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class Solution56 {

    public static void main(String[] args) {
        Solution56 solution = new Solution56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);
        for (int[] ints : result) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length == 0) return new int[0][2];

        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 遍历区间
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(result, index + 1);
    }
}
