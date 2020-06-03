package com.hsicen.lib.s119;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：hsicen  2020/6/3 15:24
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述： 杨辉三角 II
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
class Solution {

    public static void main(String[] args) {
        System.out.println("第一行：" + getRow(1));
        System.out.println("第二行：" + getRow(2));
        System.out.println("第三行：" + getRow(3));
        System.out.println("第四行：" + getRow(4));
        System.out.println("第五行：" + getRow(5));
        System.out.println("第五行：" + getRow(13));

        System.out.println("阶乘：" + pow(13));
        System.out.println("阶乘：" + pow(21));
    }

    /*** 利用二项式展开系数求解*/
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> tmp = new ArrayList<>(rowIndex + 1);
        long item = 1;

        for (int i = 0; i <= rowIndex; i++) {
            tmp.add((int) item);
            item = item * (rowIndex - i) / (i + 1);
        }

        return tmp;
    }


    /*** 计算a的阶乘*/
    public static long pow(int a) {
        if (a <= 1) return 1;
        return a * pow(a - 1);
    }

    public static void getRow(ArrayList<Integer> data) {
        for (int i = 1; i < data.size() - 1; i++) {
            data.set(i, data.get(i) + data.get(i + 1));
        }

        data.add(1);
    }
}
