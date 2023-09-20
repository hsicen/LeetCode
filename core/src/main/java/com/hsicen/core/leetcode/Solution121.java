package com.hsicen.core.leetcode;

/**
 * 作者：hsicen  2020/6/23 16:16
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：121. 买卖股票的最佳时机
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">...</a>
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 */
class Solution121 {

    public static void main(String[] args) {
        int[] data1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("最大值：" + maxProfit(data1));

        int[] data2 = new int[]{7, 6, 5, 4, 3, 2, 1};
        System.out.println("最大值：" + maxProfit(data2));
    }

    public static int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) return 0;

        int count = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++)
            if (prices[i] < min) min = prices[i];
            else {
                int tmp = prices[i] - min;
                if (tmp > count) count = tmp;
            }

        return count;
    }

}
