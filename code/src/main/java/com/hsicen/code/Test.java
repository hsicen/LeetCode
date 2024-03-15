package com.hsicen.code;

import com.hsicen.code.singleton.EnumTon;

/**
 * <p>作者：hsicen  2019/12/3 8:28
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 */
public class Test {


    public static void main(String[] args) {

        test1();
    }


    /*** 数字精度测试*/
    private static void test1() {
        //避免使用浮点数   浮点数性能比整数慢约2倍
        System.out.println("0.3f + 0.6f = " + (0.3f + 0.6f));
        System.out.println("0.3 + 0.6 = " + (0.300 * 100 + 0.6 * 100) / 100);
        System.out.println("0.9 = " + (0.9));
        System.out.println(Math.round((3495 / 1000f) * 100) / 100f);

        EnumTon instance = EnumTon.INSTANCE;
        System.out.println("result: " + instance);
        EnumTon instance1 = EnumTon.getInstance();
        System.out.println("result: " + instance1);
    }
}
