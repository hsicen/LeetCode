package com.hsicen.core.skiplist;

import androidx.annotation.NonNull;

import java.util.Random;

/**
 * <p>作者：hsicen  2019/11/27 15:35
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：跳表的实现
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    /*** 带头链表*/
    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    /*** 查找结点*/
    public boolean search(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        return p.forwards[0] != null && p.forwards[0].data == value;
    }

    /*** 插入节点*/
    public void add(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level > levelCount) level = ++levelCount;

        Node newNode = new Node(level);
        newNode.data = value;

        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = this.head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }

            if (level > i) update[i] = p;
        }

        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
    }

    /*** 插入节点*/
    public void insert2(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level > levelCount) level = ++levelCount;

        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }

            if (level > i) {
                if (p.forwards[i] == null)
                    p.forwards[i] = newNode;
                else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    /*** 删除结点*/
    public boolean erase(int num) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < num) {
                p = p.forwards[i];
            }

            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == num) {
            for (int i = levelCount - 1; i >= 0; i--)
                if (update[i].forwards[i] != null && update[i].forwards[i].data == num) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }

            return true;
        }

        return false;
    }

    /*** 随机层数*/
    private int randomLevel() {
        int level = 1;

        for (int i = 0; i < MAX_LEVEL; i++) {
            if (r.nextInt() % 2 == 1) level++;
        }

        return level;
    }

    /*** 数据打印*/
    public void printAll() {
        Node p = this.head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " > ");
            p = p.forwards[0];
        }

        System.out.println();
    }

    /*** 数据打印*/
    public void printAll2(String info) {
        System.out.println(info);

        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }

    /*** 跳表的结点， 每个结点记录了当前结点数据和所在层数*/
    public class Node {
        private int data = -1;
        private int maxLevel = 0;

        /***
         * 表示当前结点位置的下一个结点所有层的数据
         * forwards[3] 表示当前结点在第三层的下一个结点*/
        private Node[] forwards;

        public Node(int level) {
            forwards = new Node[level];
        }

        @NonNull
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }
}
