package com.hsicen.code.tree;

/**
 * <p>作者：hsicen  2020/1/17 15:22
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：堆排序测试
 */
public class HeapTest {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(8);
        heap.insert(1);
        heap.insert(45);
        heap.insert(2);
        heap.insert(7);
        heap.insert(11);
        heap.insert(21);

        heap.print();

        heap.deleteTop();
        heap.print();
    }
}
