package com.hsicen.code.leetcode;

/**
 * @author: hsicen
 * @date: 2024/3/7 21:44
 * @email: codinghuang@163.com
 * description: 80. 删除有序数组中的重复项 II
 * <p>
 * 给你一个有序数组 nums ,请你 原地 删除重复出现的元素，使每个元素 最多出现两次，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution80 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int count = 2;
        for (int pos = 2; pos < nums.length; pos++) {
            if (nums[pos] != nums[count - 2]) {
                nums[count++] = nums[pos];
            }
        }

        return count;
    }
}
