package com.hsicen.core.skiplist;


import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * <p>作者：hsicen  2019/11/27 15:35
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：跳表的实现
 * <p>
 * 不使用任何库函数，设计一个跳表。
 * 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 * 在本题中，你的设计应该要包含这些函数：
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-skiplist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * <p>
 * 0 <= num, target <= 20000
 * 最多调用 50000 次 search, add, 以及 erase操作。
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    /*** 带头链表*/
    private SNode head = new SNode(MAX_LEVEL);
    private Random r = new Random();

    /*** 查找结点*/
    public boolean search(int value) {
        SNode p = head;
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

        SNode newSNode = new SNode(level);
        newSNode.data = value;

        SNode[] update = new SNode[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        SNode p = this.head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }

            if (level > i) update[i] = p;
        }

        for (int i = 0; i < level; i++) {
            newSNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newSNode;
        }
    }

    /*** 插入节点*/
    public void insert(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level > levelCount) level = ++levelCount;

        SNode newSNode = new SNode(level);
        newSNode.data = value;
        SNode p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }

            if (level > i) {
                if (p.forwards[i] == null)
                    p.forwards[i] = newSNode;
                else {
                    SNode next = p.forwards[i];
                    p.forwards[i] = newSNode;
                    newSNode.forwards[i] = next;
                }
            }
        }
    }

    /*** 删除结点*/
    public boolean erase(int num) {
        SNode[] update = new SNode[levelCount];
        SNode p = head;
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
        SNode p = this.head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " > ");
            p = p.forwards[0];
        }

        System.out.println();
    }

    /*** 数据打印*/
    public void printAll2(String info) {
        System.out.println(info);

        SNode p = head;
        SNode[] c = p.forwards;
        SNode[] d = c;
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
    public static class SNode {
        private int data = -1;
        private int maxLevel = 0;

        /***
         * 表示当前结点位置的下一个结点所有层的数据
         * forwards[3] 表示当前结点在第三层的下一个结点*/
        private SNode[] forwards;

        public SNode(int level) {
            forwards = new SNode[level];
        }

        @NotNull
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
