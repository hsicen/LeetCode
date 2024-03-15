package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/15 15:51
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：搜索插入位置
 * <a href="https://leetcode-cn.com/problems/search-insert-position/">...</a>
 * <p>
 * 思路：将数组二分，从中间结点开始查找
 */
public class Solution035 {

    public static void main(String[] args) {
        System.out.println("result：" + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("result：" + searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("result：" + searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println("result：" + searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println("result：" + searchInsert(new int[]{1}, 2));
        System.out.println("result：" + searchInsert(new int[]{1}, 0));
        System.out.println("result：" + searchInsert(new int[]{1}, 1));
        System.out.println("result：" + searchInsert(new int[]{1}, -1));
        System.out.println("result：" + searchInsert(new int[]{1, 3}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) { //注意这个等于
            int mid = low + ((high - low) >>> 2);
            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
