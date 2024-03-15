package com.hsicen.code.linklist;

import java.util.Stack;

/**
 * <p>作者：Night  2019/3/19 14:36
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：https://leetcode.com/problems/palindrome-linked-list/
 * <p>
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * 思路：利用快慢指针找到中间位置，同时反转慢指针走过的结点，
 * 然后慢指针继续遍历后半段，和反转的前半段对比，看是否为回文串
 */
public class LeetCode234 {

    public boolean isPalindrome(Node head) {
        //判断链表是否为空或者只有一个结点值
        if (head == null || head.next == null) {
            return true;
        }

        Node fast = head;
        Node slow = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            //暂存下一个结点值
            Node next = slow.next;

            //反转慢指针
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //判断链表的长度是奇数还是偶数
        if (fast != null) {
            //链表长度为偶数
            slow = slow.next;
        }

        //前后对比
        while (prev != null && slow != null) {

            if (prev.val != slow.val) {
                return false;
            }

            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }


    /**
     * 利用栈来判断是否为回文串
     *
     * @param head 字符串数据
     * @return 结果
     */
    public boolean isPalindromeStack(Node head) {
        Stack<Integer> s = new Stack<>();
        Node cur = head;

        while (cur != null) {
            s.add(cur.val);
            cur = cur.next;
        }

        while (!s.isEmpty()) {
            Integer temp = s.peek();
            if (head.val != temp) {
                return false;
            }

            s.pop();
            head = head.next;
        }

        return true;
    }
}
