package com.hsicen.code.linklist;

/**
 * <p>作者：Night  2019/2/2 16:59
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * <p>
 * 找到有环链表环的起始结点
 */
public class FindCircleNode {


    public static Node findCircleNode(Node head) {
        Node fast = head, slow = head;
        Node meet = null;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast == null) {
                return null;
            }

            fast = fast.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }

        if (meet == null) {
            return null;
        }

        while (head != null && meet != null) {
            if (head == meet) {
                return head;
            }
            head = head.next;
            meet = meet.next;
        }

        return null;
    }

    public static boolean hasCircleNode(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while ((slow = slow.next) != null) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static Node mergeList(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }

    /**
     * 合并两个有序链表
     *
     * @param l1 l1
     * @param l2 l2
     * @return 合并后的链表
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return l2 == null ? l1 : l2;
        }

        Node first = (l2.val < l1.val) ? l2 : l1;
        first.next = mergeTwoLists(first.next, first == l1 ? l2 : l1);
        return first;
    }
}
