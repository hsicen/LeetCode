package com.hsicen.core.tree;

/**
 * <p>作者：hsicen  2020/1/15 17:52
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：堆(大堆，小堆)
 * 堆是一棵完全二叉树
 * 堆中的每一个结点的值必须大于等于(或小于等于)其子树中每个结点的值
 */
public class Heap {
    /*** 数组容器*/
    private int[] data;
    /*** 容量*/
    private int capacity;
    /*** 当前大小*/
    private int count;

    Heap(int capacity) {
        data = new int[capacity + 1]; //位置0留空
        this.capacity = capacity;
        count = 0;
    }

    /*** 插入元素(从下往上堆化)
     * @param item 被插入数据 */
    void insert(int item) {
        if (count >= capacity) return;

        //插入数据到最后一个
        ++count;
        data[count] = item;

        //堆化调整
        int i = count;
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(data, i, i / 2);
            i = i / 2;
        }
    }

    /*** 删除堆顶元素*/
    void deleteTop() {
        if (0 == count) return;

        data[1] = data[count];
        --count;
        heapify(data, count, 1);
    }

    /*** 堆化数据(由上而下)
     * @param a 原数据
     * @param n 已有数据大小
     * @param i 开始堆化位置 */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;

            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /*** 交换值
     * @param src 原数组
     * @param little 小下标
     * @param big 大下标 */
    private void swap(int[] src, int little, int big) {
        int temp = src[little];
        src[little] = src[big];
        src[big] = temp;
    }

    /*** 打印数据*/
    void print() {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + "  ");
        }

        System.out.println();
    }
}
