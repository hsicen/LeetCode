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
 * <p>
 * 二项式展开定理：后一项 = 前一项 * (k-i)/(1+i)
 */
class Solution {

    public static void main(String[] args) {
        System.out.println("第一行：" + getRow(1));
        System.out.println("第二行：" + getRow(2));
        System.out.println("第三行：" + getRow(3));
        System.out.println("第四行：" + getRow(4));
        System.out.println("第五行：" + getRow(5));
        System.out.println("第五行：" + getRow(13));
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
}
