package com.hsicen.code.linklist;

/**
 * <p>作者：Night  2019/2/1 17:26
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * <p>
 * 求两个链表的交点
 */
public class FindSameNode {

    /**
     * 找到相同结点
     *
     * @param headA headA
     * @param headB headB
     * @return 相同结点
     */
    public static Node getNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
