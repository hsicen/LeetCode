package com.hsicen.code.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: hsc
 * @date: 2025/7/1 13:51
 * @email: codinghuang@163.com
 * @description: 58.区间和
 * 给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
 * 第一行输入为整数数组 Array 的长度 n，
 * 接下来 n 行，每行一个整数，表示数组的元素。
 * 随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。
 * 输出每个指定区间内元素的总和。
 * <p>
 * 输入：
 * 5
 * <p>
 * 1 2 3 4 5
 * <p>
 * 0 1
 * 1 2
 * <p>
 * 输出：
 * 3
 * 9
 */
public class Solution58KC {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int len = scanner.nextInt();

        final int[] arr = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += scanner.nextInt();
            arr[i] = sum;
        }

        System.out.println("输入的数组为：" + Arrays.toString(arr));

        while (scanner.hasNextInt()) {
            final int a = scanner.nextInt();
            final int b = scanner.nextInt();
            System.out.println("数组区间为：" + a + "~" + b);
            System.out.println("数组区间的值为：" + arr[a] + "~" + arr[b]);

            if (0 == a) {
                System.out.println(arr[b]);
            } else {
                System.out.println(arr[b] - arr[a - 1]);
            }
        }

        scanner.close();
    }
}
