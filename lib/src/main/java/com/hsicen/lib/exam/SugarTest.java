package com.hsicen.lib.exam;

import java.util.Arrays;
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

                if (first != second) count += 1;

                System.out.println(count);
            }
        }
    }

}
