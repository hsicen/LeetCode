package com.hsicen.core.linklist;

/**
 * <p>作者：Night  2019/2/1 16:24
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * <p>
 * 链表工具类
 */
class Utils {

    /*** 打印链表*/
    static void printList(ListNode listNode) {
        System.out.println("开始打印： ");
        while (listNode != null) {
            System.out.print("->" + listNode.val);
            listNode = listNode.next;
        }

        System.out.println("\n结束打印");
    }

    /*** 反转线性表*/
    static ListNode reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    /*** 检测链表是否有环*/
    static boolean checkCircle(ListNode head) {
        if (head == null) return false;

        //利用快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    /*** 两个有序单链表的合并*/
    static ListNode mergeList(ListNode la, ListNode lb) {
        //边界条件检测
        if (la == null) return lb;
        if (lb == null) return la;

        ListNode newNode = null;

        if (la.val < lb.val) {
            newNode = new ListNode(la.val);
            la = la.next;
        } else {
            newNode = new ListNode(lb.val);
            lb = lb.next;
        }

        while (la != null && lb != null) {
            if (la.val < lb.val) {
                newNode.next = la;
                la = la.next;
            } else {
                newNode = new ListNode(lb.val);
                newNode.next = lb;
            }
        }

        if (la != null) newNode.next = la;
        if (lb != null) newNode.next = lb;

        return newNode;
    }

    /*** 删除链表倒数第n个结点*/
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        //先向前移动index个间隔
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //验证是否删除第一个结点
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    /*** 寻找链表的中间结点*/
    static ListNode findMiddle(ListNode head) {
        //检测边界条件
        if (head == null) return null;

        //利用快慢指针寻找中间结点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
