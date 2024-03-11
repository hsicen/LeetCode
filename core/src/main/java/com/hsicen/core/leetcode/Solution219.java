package com.hsicen.core.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hsicen
 * @date: 2024/3/11 22:08
 * @email: codinghuang@163.com
 * @description: 219. 存在重复元素 II
 *
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，
 * 判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false
 */
public class Solution219 {

  public static void main(String[] args) {
    Solution219 solution219 = new Solution219();
    System.out.println(solution219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    System.out.println(solution219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    System.out.println(solution219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      int num = nums[i];
      if (map.containsKey(num) && i - map.get(num) <= k) {
        return true;
      }
      map.put(num, i);
    }

    return false;
  }
}
