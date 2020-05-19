package com.hsicen.lib.s69;

/**
 * 作者：hsicen  2020/5/18 15:36
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：计算一个数(非负整数)的平方根的整数部分
 * https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 思路：二分查找计算
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("Result：" + mySqrt(0));
        System.out.println("Result：" + mySqrt(1));
        System.out.println("Result：" + mySqrt(2));
        System.out.println("Result：" + mySqrt(3));
        System.out.println("Result：" + mySqrt(4));
        System.out.println("Result：" + mySqrt(5));
        System.out.println("Result：" + mySqrt(6));
        System.out.println("Result：" + mySqrt(7));
        System.out.println("Result：" + mySqrt(8));
        System.out.println("Result：" + mySqrt(9));
        System.out.println("Result：" + mySqrt(10));
        System.out.println("Result：" + mySqrt(16));
        System.out.println("Result：" + mySqrt(17));
        System.out.println("Result：" + mySqrt(100));
        System.out.println("Result：" + mySqrt(2147395599));
    }

    /*** 牛顿迭代法计算*/
    public static int mySqrt(int x) {
        if (0 == x || 1 == x) return x;

        return ((int) square(x, x));
    }

    private static double square(double x, int target) {
        double res = (x + target / x) / 2;

        if (res == x) {
            return x;
        } else {
            //继续迭代
            return square(res, target);
        }
    }

    private double squart(double start, int target) {
        //计算近似值
        double tmp = (start + target / start) / 2;

        if (tmp == start) return start;
        else return squart(tmp, target);
    }

    /*** 二分法查找值*/
    public static int mySqrt1(int x) {
        if (0 == x || 1 == x) return x;

        int low = 0;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == x / mid) return mid;

            if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
    }

}
