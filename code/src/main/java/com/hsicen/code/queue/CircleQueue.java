package com.hsicen.code.queue;

/**
 * <p>作者：Night  2019/3/22 17:35
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：基于数组实现的循环队列
 */
public class CircleQueue {
    private int[] items;
    private int n;

    private int head = 0;
    private int tail = 0;

    public CircleQueue(int n) {
        items = new int[n];
        this.n = n;
    }

    /*** 入队操作*/
    public boolean enQueue(int data) {
        //队满判断
        if ((tail + 1) % n == head) return false;

        items[tail] = data;
        tail = (tail + 1) % n;

        return true;
    }

    /*** 出队操作*/
    public int deQueue() {
        //队空判断
        if (tail == head) return -1;

        int value = items[head];
        head = (head + 1) % n;

        return value;
    }
}
