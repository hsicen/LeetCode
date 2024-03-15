package com.hsicen.code.linklist;

/**
 * <p>作者：Night  2019/2/1 16:23
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 * 链表测试
 */
public class Test {


    public static void main(String[] args) {
        Node node = createList();

        //testReverse(listNode);
        //ListNode reverse = ReverseRange.Reverse(listNode, 2, 4);

        NodeUtils.printList(node);
        Node moveNode = NodeUtils.removeNthFromEnd(node, 2);
        NodeUtils.printList(moveNode);
    }

    /**
     * 测试单链表反转
     *
     * @param node listNode
     */
    private static void testReverse(Node node) {
        NodeUtils.printList(node);

        long start = System.currentTimeMillis();
        System.out.println("begin: " + start);
        Node reverse = ReverseListKt.Reverse(node);
        long end = System.currentTimeMillis();
        System.out.println("end: " + end);
        System.out.println("totalTime: " + (end - start));
        NodeUtils.printList(reverse);
    }

    /**
     * @return 创建单链表
     */
    private static Node createList() {
        Node head = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        return head;
    }

}
