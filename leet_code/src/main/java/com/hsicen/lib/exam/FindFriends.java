package com.hsicen.lib.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 作者：hsicen  2020/5/14 14:11
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：寻找身高最小的朋友
 * <p>
 * 输入2个数：N和M，N表示学生总人数，M表示有M组(u,v)信息，表示u比v小
 * 从这M组信息中找出可能身高最小人，然后输出，这就是你可能的朋友
 */
public class FindFriends {

    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();

            ArrayList<Integer> highStu = new ArrayList<>(n);
            ArrayList<Integer> lowStu = new ArrayList<>(n);

            for (int i = 0; i < m; i++) {
                int low = sc.nextInt();
                int high = sc.nextInt();

                if (!highStu.contains(low) && !lowStu.contains(low)) {
                    lowStu.add(low);
                }

                if (!highStu.contains(high)) {
                    highStu.add(high);
                }

                if (lowStu.contains(high)) {
                    lowStu.remove((Integer) high);
                }
            }

            for (Integer stu : lowStu) {
                System.out.print(stu + " ");
            }

            System.out.println();
        }
    }
}
