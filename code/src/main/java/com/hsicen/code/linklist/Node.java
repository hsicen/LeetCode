package com.hsicen.code.linklist;

/**
 * <p>作者：Night  2019/2/1 16:19
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * <p>
 * 单链表定义
 */
public class Node {
    /*** 结点值*/
    public int val;
    /*** 下一个结点*/
    public Node next = null;

    public Node(int data) {
        this.val = data;
    }
}