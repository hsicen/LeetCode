package com.hsicen.lib.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 作者：hsicen  2020/5/13 20:11
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：找到最小编号
 * 思路：
 * 最大数组和最小数组存储每组数据
 * 每次遍历数据前看最大数中是否最小数，没有则放入最小数中，最后输出最小数组
 */
public class Main {

    public static void main(String[] args) {

        //sugar();
        findFriends();
    }

    private static void findFriends() {
        int n;
        int m;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();

            ArrayList<Integer> maxStudents = new ArrayList<>(n);
            ArrayList<Integer> minStudents = new ArrayList<>(n);

            for (int i = 0; i < m; i++) {
                int small = sc.nextInt();
                int large = sc.nextInt();

                if (!maxStudents.contains(small) && !minStudents.contains(small)) {
                    minStudents.add(small);
                }

                if (!maxStudents.contains(large)) {
                    maxStudents.add(large);
                }

                if (minStudents.contains(large)) {
                    minStudents.remove((Integer) large);
                }
            }

            for (Integer minStudent : minStudents) {
                System.out.print(minStudent + " ");
            }
            System.out.println();
        }
    }

    private static void sugar() {
        Scanner sc = new Scanner(System.in);
        String data;
        int count;
        while (sc.hasNext()) {
            data = sc.nextLine();

            String[] students = data.split(",");
            count = students.length;
            if (count > 1) {
                Integer first = Integer.valueOf(students[0]);
                for (int i = 1; i < students.length; i++) {
                    Integer second = Integer.valueOf(students[i]);
                    if (first.intValue() != second.intValue()) {
                        count += 1;
                    }
                    first = second;
                }

                System.out.println(count);
            } else {
                System.out.println(count);
            }
        }
    }

    public int candy(int[] ratings) {
        int count = ratings.length;

        if (1 >= count) {
            return count;
        } else if (2 == count) {
            int first = ratings[0];
            int second = ratings[1];

            if (first != second) count += 1;
        } else {
            int first = ratings[0];
            int second = ratings[1];
            if (first != second) count += 1;

            for (int i = 2; i < ratings.length; i++) {
                int third = ratings[i];

                if (second < first && second < third) {
                    count += 1;
                } else if (first >= second && second > third) {
                    count += 1;
                }

                first = second;
                second = third;
            }
        }

        return count;
    }
}
