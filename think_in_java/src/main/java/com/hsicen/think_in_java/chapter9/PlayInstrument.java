package com.hsicen.think_in_java.chapter9;

/**
 * 作者：hsicen  2020/6/20 21:33
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class PlayInstrument {

    public static void playInstrument(Instrument instrument) {
        instrument.play();
    }

    public static void main(String[] args) {

        Instrument instrument = new Instrument() {
            @Override
            void play() {
                System.out.println("匿名内部类的弹奏方法");
            }
        };

        Piano piano = new Piano();


        playInstrument(instrument);
        playInstrument(piano);
    }
}
