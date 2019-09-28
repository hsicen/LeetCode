package com.hsicen.core.linklist;

/**
 * <p>作者：Night  2019/2/1 14:50
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * <p>
 * 逆置线性表 (不申请新的存储空间)
 */
public class ReverseListJava {

    public ListNode Reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}

