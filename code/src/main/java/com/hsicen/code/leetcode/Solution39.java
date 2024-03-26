package com.hsicen.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hsc
 * @date: 2024/3/26 16:00
 * @email: codinghuang@163.com
 * @description: 39.Combination Sum
 * <p>
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <p>
 * The same number my be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.
 */
public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        List<List<Integer>> result = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println("******====== 代码分割线 ======******");

        List<List<Integer>> result2 = solution.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : result2) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        /// 定义一维动态规划数组
        int[] dp = new int[target + 1];
        dp[0] = 1; // 初始化，表示组成和为0的方法数为1

        // 动态规划求解
        for (int candidate : candidates) {
            for (int j = candidate; j <= target; j++) {
                dp[j] += dp[j - candidate];
            }
        }

        // 回溯结果
        backtrack(result, new ArrayList<>(), candidates, dp, target, candidates.length);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int[] candidates, int[] dp, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (index <= 0 || target < 0) {
            return;
        }

        // 当前数字不选
        backtrack(result, combination, candidates, dp, target, index - 1);

        // 当前数字选取
        if (target >= candidates[index - 1] && dp[target - candidates[index - 1]] > 0) {
            combination.add(candidates[index - 1]);
            backtrack(result, combination, candidates, dp, target - candidates[index - 1], index);
            combination.remove(combination.size() - 1);
        }
    }
}
