package com.hsicen.core.linklist;

/**
 * <p>作者：Night  2019/2/1 16:23
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * 链表测试
 */
public class Test {


    public static void main(String[] args) {
        ListNode listNode = createList();

        //testReverse(listNode);
        //ListNode reverse = ReverseRange.Reverse(listNode, 2, 4);

        Utils.printList(listNode);
        ListNode moveNode = Utils.removeNthFromEnd(listNode, 2);
        Utils.printList(moveNode);
    }

    /**
     * 测试单链表反转
     *
     * @param listNode
     *         listNode
     */
    private static void testReverse(ListNode listNode) {
        Utils.printList(listNode);

        long start = System.currentTimeMillis();
        System.out.println("begin: " + start);
        ListNode reverse = ReverseListKt.Reverse(listNode);
        long end = System.currentTimeMillis();
        System.out.println("end: " + end);
        System.out.println("totalTime: " + (end - start));
        Utils.printList(reverse);
    }

    /**
     * @return 创建单链表
     */
    private static ListNode createList() {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        return head;
    }

}
