package com.hsicen.core.leetcode;

/**
 * @author: hsicen
 * @date: 2024/3/9 20:48
 * @email: codinghuang@163.com
 * @description: 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums  ,返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * 输入:nums = [3,2,3]
 * 输出:3
 * <p>
 * 示例 2:
 * 输入:nums = [2,2,1,1,1,2,2]
 * 输出:2
 */
public class Solution169 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 1, 3, 3, 1};
        int majorityElement = new Solution169().majorityElement(nums);
        System.out.println(majorityElement);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return;

        int pivot = partition(nums, start, end);
        sort(nums, start, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = nums[i];
                    nums[i++] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        nums[end] = nums[i];
        nums[i] = pivot;

        return i;
    }
}
