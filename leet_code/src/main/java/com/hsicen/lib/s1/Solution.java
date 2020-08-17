package com.hsicen.lib.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：hsicen  2020/8/17 19:51
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述： 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
class Solution {

    //暴力算法，两遍遍历数组
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    index[0] = i;
                    index[1] = j;

                    return index;
                }
            }
        }

        return null;
    }

    //利用hashMap求解   [另一个值]->[index]
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
