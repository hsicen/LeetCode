package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/4 17:49
 * @email: codinghuang@163.com
 * @description: 24.两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 */
object Solution24 {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        val newHead = ListNode(0, head)
        var cur: ListNode? = newHead
        while (cur?.next != null && cur.next?.next != null) {
            val first = cur.next
            val third = cur.next?.next?.next

            cur.next = cur.next?.next
            cur.next?.next = first
            cur.next?.next?.next = third

            cur = cur.next?.next
        }

        return newHead.next
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val node4 = ListNode(4)
        val node3 = ListNode(3, node4)
        val node2 = ListNode(2, node3)
        val node1 = ListNode(1, node2)
        node1.printNode("交换前：", node1)
        val newHead = swapPairs(node1)
        newHead?.printNode("交换后：", newHead)
    }
}