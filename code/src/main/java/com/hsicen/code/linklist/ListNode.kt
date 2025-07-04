package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/3 18:29
 * @email: codinghuang@163.com
 * @description: ListNode结点定义
 */
data class ListNode(
    var `val`: Int,
    var next: ListNode? = null
) {

    fun printNode(head: ListNode?) {
        var cur = head
        while (cur != null) {
            print("${cur.`val`} ")
            cur = cur.next
        }
        println()
    }

    fun printNode(msg: String, head: ListNode?) {
        var cur = head
        print(msg)
        while (cur != null) {
            print("${cur.`val`} ")
            cur = cur.next
        }
        println()
    }
}