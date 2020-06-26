package com.hsicen.lib.s118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作者：hsicen  2020/6/23 15:05
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
class Solution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return Collections.emptyList();

        List<List<Integer>> lists = new ArrayList<>();
        while (numRows-- > 0) {
            lists.add(0, getRow(numRows));
        }

        return lists;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<>(rowIndex + 1);
        long item = 1;

        for (int i = 0; i <= rowIndex; i++) {
            tmp.add((int) item);
            item = item * (rowIndex - i) / (i + 1);
        }

        return tmp;
    }
}
