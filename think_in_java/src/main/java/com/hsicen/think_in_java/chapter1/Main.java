package com.hsicen.think_in_java.chapter1;

import java.util.Random;

/**
 * 作者：hsicen  2020/6/6 21:14
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class Main {

    public static void main(String[] args) {


    }


    private static void blodNum() {

        for (int i = 1000; i < 9999; i++) {
            if (i % 100 == 0) continue;

            int a = i / 1000;
            int b = i / 100 % 10;
            int c = i / 10 % 100;
            int d = i % 1000;
        }
    }


    private static void testFibona() {
        for (int i = 1; i <= 5; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println();
    }

    private static int fibonacci(int value) {
        if (value <= 2) {
            return 1;
        }

        return fibonacci(value - 1) + fibonacci(value - 2);
    }

    private static void bitCount() {
        float value = 1.39e27f;

        int i = 1 << 2;
        int i1 = 1 >>> 3;
    }

    private static void coinSituation() {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        System.out.println(i);
        System.out.println(i % 2);
        System.out.println("正面：" + ((i % 2) == 1));
    }

    private static void testEquals() {
        Test2 t1 = new Test2();
        Test2 t2 = new Test2();

        t1.value = 100;
        t2.value = 100;

        //== 比较引用；equals() 默认比较引用；重写equal必须先重写hashCode
        System.out.println("==：" + (t1 == t2));
        System.out.println("equals：" + (t1.equals(t2)));
    }

    private static void autoInc() {
        int i = 1;

        System.out.println("i:  " + i);
        System.out.println("i++:    " + i++);
        System.out.println("i:  " + i);

        System.out.println("++i:    " + ++i);
        System.out.println("i:  " + i);
    }

    private static void mathOps() {
        int x = 1, a = 2, b = 3;

        x = -a;
        x = a * -b;
        System.out.println("result：" + x);

        char i = 'a';
        char j = (char) +i;
        int k = +i;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        float c = +1.2f;
        System.out.println(c);
    }

    private static void testRandom() {
        Random random = new Random(27);
        System.out.println("随机数：" + random.nextInt(100));
        System.out.println("随机数：" + random.nextInt(100));
        System.out.println("随机数：" + random.nextInt(100));
    }

    private static void testNickName() {
        Test2 t1 = new Test2();
        Test2 t2 = new Test2();

        System.out.println("初始化：" + t1.value);

        t1.value = 3;
        t2.value = 4;
        System.out.println("t1：" + t1.value + "  t2：" + t2.value);

        t1 = t2;
        t1.value = 5;
        t2.value = 6;
        System.out.println("t1：" + t1.value + "  t2：" + t2.value);
    }

    private static void testInit() {
        Test1 test = new Test1(1);
        System.out.println("结果：" + test.test1);
        System.out.println("结果：" + (int) test.test2);
    }
}
