package com.hsicen.think_in_java.chapter8;


/**
 * 作者：hsicen  2020/6/13 16:46
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class Wind extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Wind is play " + note);

        char c = 'z';
        int a = +c;
    }
}
