package com.hsicen.think_in_java.chapter8;

/**
 * 作者：hsicen  2020/6/13 16:52
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class Music {

    public static void tune(Instrument instrument) {
        instrument.play(Note.宫);
        instrument.clear();
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        tune(wind);
    }

}
