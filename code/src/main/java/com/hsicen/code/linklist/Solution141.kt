package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/11 14:12
 * @email: codinghuang@163.com
 * @description: 141.环形链表
 * 给你一个单链表的头节点 head ，判断该链表是否为回文链表。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */
object Solution141 {

    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next

        while (fast != null) {
            fast = fast.next?.next
            slow = slow?.next

            if (fast == slow) {
                return true
            }
        }

        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }
}