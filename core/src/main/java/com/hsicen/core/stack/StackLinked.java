package com.hsicen.core.stack;

import com.night.leetcode.linkedlist.ListNode;

/**
 * <p>作者：Night  2019/3/20 20:14
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：基于单链表的栈的实现
 */
public class StackLinked {
    private ListNode top = null;
    //当前栈中元素的个数
    private int count = 0;


    /*** 入栈操作(头插法)*/
    public void push(int item) {
        ListNode newNode = new ListNode(item);

        //第一个元素入栈
        if (top == null) {
            top = newNode;
        } else {
            //头插法插入新结点
            newNode.next = top;
            top = newNode;
        }

        count++;
    }

    /*** 出栈操作(头结点值)
     *   返回-1表示失败
     * */
    public int pop() {
        if (top == null) return -1;

        int value = top.val;
        top = top.next;
        count--;
        return value;
    }

    /*** 获取栈顶元素值*/
    public int peek() {
        if (top == null) return -1;

        return top.val;
    }
}
