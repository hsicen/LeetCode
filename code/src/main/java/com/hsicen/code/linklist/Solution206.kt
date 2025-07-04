package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/4 17:34
 * @email: codinghuang@163.com
 * @description: 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
object Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return head

        var pre: ListNode? = null
        var cur: ListNode? = head
        while (cur != null) {
            val tmp = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
        }

        return pre
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val node6 = ListNode(6)
        val node5 = ListNode(5, node6)
        val node4 = ListNode(4, node5)
        val node3 = ListNode(3, node4)
        val node2 = ListNode(2, node3)
        val node1 = ListNode(1, node2)

        val newHead = reverseList(node1)
        newHead?.printNode(newHead)
    }
}