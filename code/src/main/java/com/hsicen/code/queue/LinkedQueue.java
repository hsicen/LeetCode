package com.hsicen.code.queue;


import com.hsicen.code.linklist.Node;

/**
 * <p>作者：Night  2019/3/22 17:02
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：利用单链表实现队列操作
 */
public class LinkedQueue {
    //队头(出队)
    private Node head;
    //队尾(入队)
    private Node tail;

    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();

        lq.enQueue(1);
        lq.enQueue(2);
        lq.enQueue(3);
        lq.enQueue(4);
        lq.deQueue();
        lq.paintAll();
    }

    /*** 入队操作*/
    public void enQueue(int data) {
        Node node = new Node(data);

        //队空判断
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            //尾插法(新节点插入到表尾)
            tail.next = node;
            tail = tail.next;
        }
    }

    /*** 出队操作*/
    public int deQueue() {
        if (head == null) return -1;

        int data = head.val;
        head = head.next;

        return data;
    }

    public void paintAll() {
        Node p = this.head;

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
