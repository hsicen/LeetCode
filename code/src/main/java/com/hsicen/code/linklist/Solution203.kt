package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/3 18:11
 * @email: codinghuang@163.com
 * @description: 203.移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
object Solution203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val preHead = ListNode(-1, head)
        var current = preHead

        while (current.next != null) {
            current.next?.let {
                if (it.`val` == `val`) {
                    current.next = it.next
                } else {
                    current = it
                }
            }
        }

        return preHead.next
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val node7 = ListNode(6, null)
        val node6 = ListNode(5, node7)
        val node5 = ListNode(4, node6)
        val node4 = ListNode(3, node5)
        val node3 = ListNode(6, node4)
        val node2 = ListNode(2, node3)
        val node1 = ListNode(1, node2)

        var newHead = removeElements(node1, 3)
        while (newHead != null) {
            println(newHead.`val`)
            newHead = newHead.next
        }
    }
}
