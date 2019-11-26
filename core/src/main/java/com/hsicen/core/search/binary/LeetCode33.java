package com.hsicen.core.search.binary;

/**
 * <p>作者：hsicen  2019/11/26 16:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * <p>
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
        int[] data = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
        int[] data1 = new int[]{5, 6, 7, 1, 2, 3, 4};

        System.out.println("查找1：下标为：  " + search(data, 1));
        System.out.println("查找7：下标为：  " + search(data, 5));
        System.out.println("查找1： 下标为： " + search(data1, 1));
    }

    private static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int start, int end, int target) {
        int mid = start + ((end - start) >> 1);

        if (nums[start] > nums[mid]) {
            //首元素大于mid  后半部分有序   前半部分循环有序   判断目标元素在哪个区间
            if (nums[end] >= target) {
                //目标元素在有序数组中  middle+1---end
                return binarySearch(nums, mid + 1, end, target);
            } else {
                //目标元素在循环有序数组中
                search(nums, start, mid, target);
            }
        } else {
            //首元素小于mid  前半部分有序   后半部分循环有序   判断目标元素在哪个区间
            if (nums[mid] >= target) {
                //目标元素在有序数组中 start---middle
                return binarySearch(nums, start, mid, target);
            } else {
                //目标元素在循环有序数组中
                search(nums, mid + 1, end, target);
            }
        }

        return -1;
    }

    private static int binarySearch(int[] src, int low, int high, int value) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (value == src[mid]) {
                return mid;
            }

            if (value > src[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
