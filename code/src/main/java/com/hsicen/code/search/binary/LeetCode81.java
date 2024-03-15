package com.hsicen.code.search.binary;

/**
 * <p>作者：hsicen  2019/11/27 11:28
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class LeetCode81 {

    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println("是否包含元素0：" + search(data, 0));
        System.out.println("是否包含元素2：" + search(data, 2));
        System.out.println("是否包含元素-1：" + search(data, -1));
        System.out.println("是否包含元素100：" + search(data, 100));
    }


    private static boolean search(int[] nums, int target) {
        if (nums == null || 0 == nums.length) return false;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return false;
    }
}
