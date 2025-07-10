package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/10 11:26
 * @email: codinghuang@163.com
 * @description: 19.删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
object Solution19 {

    // 快慢指针法求解
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val tmpHead = ListNode(-1)
        tmpHead.next = head

        var fast: ListNode? = tmpHead
        var slow: ListNode? = tmpHead

        // 1.快指针先移动 n 步
        repeat(n) {
            fast = fast?.next
        }

        // 2.快慢指针同时移动，当快指针到达链表末尾时，慢指针指向的节点就是倒数第 n 个节点
        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }

        // 3.删除倒数第 n 个节点
        slow?.next = slow.next?.next

        return tmpHead.next
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val node5 = ListNode(5)
        val node4 = ListNode(4, node5)
        val node3 = ListNode(3, node4)
        val node2 = ListNode(2, node3)
        val node = ListNode(1, node2)

        node.printNode("初始链表：", node)
        val result = removeNthFromEnd(node, 2)
        result?.printNode("删除倒数第 2 个节点：", result)

        val node12 = ListNode(2)
        val node1 = ListNode(1, node12)
        val result1 = removeNthFromEnd(node1, 1)
        result1?.printNode("删除倒数第 1 个节点：", result1)

    }
}