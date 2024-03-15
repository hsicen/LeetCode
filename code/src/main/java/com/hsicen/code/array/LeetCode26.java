package com.hsicen.core.array;

/**
 * <p>作者：Night  2019/3/5 17:39
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：26. 不分配新的空间，去除有序数组中的重复项,并返回数组新的长度
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {

        //如果数组为空或者长度为1
        if (0 == nums.length || 1 == nums.length) return nums.length;

        //记录新数组的长度
        int newLength = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[newLength]) {
                //数值不相等  赋值元素
                newLength++;
                nums[newLength] = nums[i];
            }
        }

        return ++newLength;
    }

}
