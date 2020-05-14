package com.hsicen.lib.exam;

import java.util.Scanner;

/**
 * 作者：hsicen  2020/5/14 11:41
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：给一排的同学分糖果，保证至少每个人都可以分到一块，每相邻的人成绩更好的可以分到更多，问老师至少需要准备多少糖
 * 学生的成绩以一排数据给出，用分号隔开
 */
public class SugarTest {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int count;

        while (reader.hasNext()) {
            //读取学生成绩数据
            String scoreData = reader.nextLine();

            String[] scores = scoreData.split(",");
            count = scores.length;
            int[] counts = new int[count];

            for (int i = 0; i < count; i++) {
                counts[i] = 1;
            }

            if (1 >= count) {
                System.out.println(count);
            } else if (2 == count) {
                int first = Integer.parseInt(scores[0]);
                int second = Integer.parseInt(scores[1]);

                if (first != second) count += 1;
                System.out.println(count);
            } else {
                int first = Integer.parseInt(scores[0]);
                int second = Integer.parseInt(scores[1]);

                if (first > second) {
                    counts[0] = counts[0] + 1;
                } else if (second > first) {
                    counts[1] = counts[1] + 1;
                }

                if (first != second) count += 1;

                for (int i = 2; i < scores.length; i++) {
                    int third = Integer.parseInt(scores[i]);

                    if (second < first && second < third) {
                        counts[i] = counts[i - 1] + 1;
                    }

                    first = second;
                    second = third;
                }

                System.out.println(count);
            }
        }
    }

}
