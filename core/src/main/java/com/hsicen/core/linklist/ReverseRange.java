package com.hsicen.core.linklist;

/**
 * <p>作者：Night  2019/2/1 16:42
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * <p>
 * <p>
 * 逆置单链表指定区间(不申请额外空间)
 */
public class ReverseRange {

    /**
     * 逆置单链表
     *
     * @param head head
     * @param m    start
     * @param n    end
     * @return ListNode
     */
    public static ListNode Reverse(ListNode head, int m, int n) {
        int changeLen = n - m + 1;
        ListNode preHead = null;
        ListNode result = head;

        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }

        ListNode modifyListTail = head;
        ListNode newHead = null;

        while (head != null && changeLen > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            changeLen--;
        }

        modifyListTail.next = head;

        if (preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }

        return result;
    }
}
