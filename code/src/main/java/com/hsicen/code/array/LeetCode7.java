package com.hsicen.code.array;

/**
 * <p>作者：Night  2019/3/6 17:44
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：https://leetcode.com/problems/remove-element/
 * <p>
 * 27. Remove Element
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class LeetCode7 {

    int removeElement(int[] nums, int val) {

        //如果数组为空，直接返回
        if (nums.length == 0) return 0;

        //记录新数组的长度
        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                //当前元素不是被移除元素
                nums[newLength] = nums[i];
                newLength++;
            }
        }

        return newLength;
    }
}
