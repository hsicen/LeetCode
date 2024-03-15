package com.hsicen.code.search.binary;

/**
 * <p>作者：hsicen  2019/11/26 16:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class LeetCode33 {

    public static void main(String[] args) {
        int[] data = new int[]{5, 6, 7, 8, 9, 0, 1, 2, 3, 4};
        int[] data1 = new int[]{5, 6, 7, 1, 2, 3, 4};

        System.out.println("查找1：下标为：  " + search(data, 1));
        System.out.println("查找7：下标为：  " + search(data, 4));
        System.out.println("查找1： 下标为： " + search(data1, 1));
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                low = mid + 1;  //向后规约
            else
                high = mid;  //向前规约
        }

        return low == high && nums[low] == target ? low : -1;
    }

}
