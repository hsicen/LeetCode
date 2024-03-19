package com.hsicen.code.leetcode;

/**
 * @author: hsc
 * @date: 2024/3/19 16:37
 * @email: codinghuang@163.com
 * @description: 300. Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Explanation: The longest increasing subsequence is [0,1,2,3], therefore the length is 4.
 * <p>
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class Solution300 {

    public static void main(String[] args) {
        Solution300 solution = new Solution300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums));

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(nums2));

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(nums3));
    }

    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int[] tail = new int[nums.length];
        int index = 0;
        tail[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[index]) {
                tail[++index] = nums[i];
            } else if (nums[i] < tail[index]) {
                int tmpIdx = index;
                while (tmpIdx >= 0 && nums[i] <= tail[tmpIdx]) {
                    tmpIdx--;
                }
                tail[tmpIdx + 1] = nums[i];
            }
        }

        return index + 1;
    }
}
