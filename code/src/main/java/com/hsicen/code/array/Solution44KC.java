package com.hsicen.code.array;

import java.util.Scanner;

/**
 * @author: hsc
 * @date: 2025/7/1 15:11
 * @email: codinghuang@163.com
 * @description: 44.开发商购买土地
 * 在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。
 * 目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
 * <p>
 * 现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
 * <p>
 * 然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。
 * <p>
 * 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
 * 注意：区块不可再分。
 * <p>
 * 【输入描述】
 * 第一行输入两个正整数，代表 n 和 m。
 * 接下来的 n 行，每行输出 m 个正整数。
 * <p>
 * 【输出描述】
 * 输出一个正整数，代表 A 公司和 B 公司的子区域内的土地价值之差最小值。
 */
public class Solution44KC {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        int sum = 0;

        // 读取数组数据
        final int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                sum += matrix[i][j];
            }
        }

        // 统计每横行的值
        int[] rowSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += matrix[i][j];
            }
        }

        // 统计每竖列的值
        int[] columnSum = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                columnSum[j] += matrix[i][j];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        // 横向切割
        int rowCut = 0;
        for (int i = 1; i < n; i++) {
            rowCut += rowSum[i];
            minDiff = Math.min(minDiff, Math.abs((sum - rowCut) - rowCut));
        }

        // 纵向切割
        int columnCut = 0;
        for (int j = 1; j < m; j++) {
            columnCut += columnSum[j];
            minDiff = Math.min(minDiff, Math.abs((sum - columnCut) - columnCut));
        }

        System.out.println(minDiff);
    }
}
