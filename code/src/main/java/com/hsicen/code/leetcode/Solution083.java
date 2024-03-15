package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/18 17:34
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：删除有序链表中的重复元素
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">...</a>
 * <p>
 * 思路: 小标标记，遍历链表对比值是和否相等
 */
public class Solution083 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = deleteDuplicates(node1);
        System.out.println("Result：" + head);
    }

    /*** 循环遍历链表去除重复结点*/
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode tmp = head;

        while (tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else tmp = tmp.next;
        }

        return head;
    }

    /*** 递归求解  递归寻找head的next结点*/
    public static ListNode deleteDuplicates1(ListNode head) {
        if (null == head || null == head.next) return head;

        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } else head.next = deleteDuplicates(head.next);

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
