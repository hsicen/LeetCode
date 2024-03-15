package com.hsicen.code.leetcode;

/**
 * @author: hsc
 * @date: 2024/3/15 17:25
 * @email: codinghuang@163.com
 * @description: 137. 只出现一次的数字 II
 *
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都出现 三次
 */
public class Solution137 {

    public static void main(String[] args) {
        Solution137 solution = new Solution137();
        int[] nums = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
