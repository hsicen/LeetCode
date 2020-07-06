package com.hsicen.think_in_java.chapter11.snow;

import java.util.Arrays;
import java.util.List;

/**
 * 作者：hsicen  2020/7/6 23:46
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class AsListTest {

    public static void main(String[] args) {

        List<Snow> snows = Arrays.asList(new Crusty(), new Slush(), new Powder(), new Snow(), new Light());

        List<Powder> powders = Arrays.asList(new Light(), new Heavy());

        List<Snow> snows1 = Arrays.<Snow>asList(new Light(), new Heavy());
    }
}
