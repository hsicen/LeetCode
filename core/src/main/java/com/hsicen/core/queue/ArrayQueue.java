package com.hsicen.core.queue;

/**
 * <p>作者：Night  2019/3/22 16:41
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：基于数组实现队列
 *
 * 队列是先进先出的数据结构，拥有队尾(tail)和队头(head)
 * 从tail插入元素，head删除元素
 */
public class ArrayQueue {
    private int[] items;
    private int capacity;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        this.capacity = capacity;
    }

    /*** 入队操作*/
    public boolean enQueue(int data) {
        //队满判断
        if (tail == capacity) {
            if (head == 0) return false;

            System.arraycopy(items, head, items, 0, tail - head);
            tail = tail - head;
            head = 0;
        }

        items[tail] = data;
        tail++;

        return true;
    }

    /*** 出队操作*/
    public int deQueue() {
        //队空判断
        if (tail == head) return -1;

        int data = items[head];
        head++;

        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head->tail：");

        for (int i = head; i < tail; i++) {
            sb.append(items[i]).append(",");
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        aq.enQueue(2);
        aq.enQueue(3);
        aq.enQueue(4);
        aq.enQueue(5);
        aq.enQueue(6);
        aq.enQueue(7);

        aq.deQueue();
        aq.enQueue(23);

        System.out.println(aq.toString());

    }
}
