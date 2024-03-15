package com.hsicen.code.leetcode;

/**
 * 作者：hsicen  2020/5/22 12:07
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：单链表反转
 */
public class Solution206 {

  public static void main(String[] args) {

  }

  public static ListNode reverseList(ListNode head) {
    if (null == head || null == head.next) return head;

    ListNode newHead = null;

    while (null != head) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }

    return newHead;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
