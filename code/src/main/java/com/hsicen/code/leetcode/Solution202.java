package com.hsicen.code.leetcode;

/**
 * @author: hsc
 * @date: 2024/3/15 14:49
 * @email: codinghuang@163.com
 * @description: 202. 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Solution202 {
    public static void main(String[] args) {
        Solution202 solution = new Solution202();

        // 测试示例
        System.out.println(solution.isHappy(19));  // 应该输出 true
        System.out.println(solution.isHappy(2));   // 应该输出 false
    }

    public boolean isHappy(int n) {
        // 使用快慢指针的方法来检测循环
        int slow = n;
        int fast = getNext(n);

        // 当快指针达到1或快慢指针相遇时停止
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);  // 慢指针移动一步
            fast = getNext(getNext(fast));  // 快指针移动两步
        }

        // 如果快指针达到1，则为快乐数
        return fast == 1;
    }

    // 获取每一位的平方和
    private int getNext(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10; // 取余
            number /= 10; // 取模
            totalSum += digit * digit;
        }
        return totalSum;
    }
}
