package com.hsicen.code.leetcode;

import java.util.Arrays;

/**
 * @author: hsc
 * @date: 4/17/2024 5:43 PM
 * @email: codinghuang@163.com
 * @description: 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入：nums = [1,2,3,4,5,6,7], k = 3
 * 输出：[5,6,7,1,2,3,4]
 * 解释：
 * 旋转 1 次: [7,1,2,3,4,5,6]
 * 旋转 2 次: [6,7,1,2,3,4,5]
 * 旋转 3 次: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 旋转 1 次: [99,-1,-100,3]
 * 旋转 2 次: [3,99,-1,-100]
 */
public class Solution189 {

    public static void main(String[] args) {
        final Solution189 solution = new Solution189();
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums1, 8);
        System.out.println(Arrays.toString(nums1));
        System.out.println("******====== 分割线 ======******");

        int[] nums2 = new int[]{-1, -100, 3, 99};
        solution.rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            reverse(nums);
            System.out.println("第" + (i + 1) + "次交换结果：" + Arrays.toString(nums));
        }
    }

    public void reverse(int[] nums) {
        int tmp = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = tmp;
    }
}
