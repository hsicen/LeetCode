package com.hsicen.think_in_java.chapter1;

import java.util.Objects;

/**
 * 作者：hsicen  2020/6/6 21:32
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class Test2 implements Cloneable {
    float value;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test2 test2 = (Test2) o;
        return Float.compare(test2.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
