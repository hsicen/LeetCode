package com.hsicen.think_in_java.chapter10;

/**
 * 作者：hsicen  2020/6/22 8:50
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class MultiInterface {

    interface IA {
        void a();
    }

    interface IB {
        void b();
    }

    abstract class A {
        abstract void a();
    }

    abstract class B {
        abstract void b();
    }


    class TestIA extends A {

        @Override
        void a() {

        }

        B getB() {
            return new B() {
                @Override
                void b() {

                }
            };
        }
    }
}
