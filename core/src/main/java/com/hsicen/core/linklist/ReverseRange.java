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
    public static Node Reverse(Node head, int m, int n) {
        int changeLen = n - m + 1;
        Node preHead = null;
        Node result = head;

        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }

        Node modifyListTail = head;
        Node newHead = null;

        while (head != null && changeLen > 0) {
            Node next = head.next;
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
