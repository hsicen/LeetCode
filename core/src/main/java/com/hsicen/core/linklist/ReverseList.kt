package com.hsicen.core.linklist

/**
 * 作者：Night  2019/2/1 14:33
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 *
 * 翻转线性表
 */

fun Reverse(head: ListNode?): ListNode? {
    var temp = head
    var newHead: ListNode? = null

    while (temp != null) {
        val next = temp.next
        temp.next = newHead
        newHead = temp
        temp = next
    }

    return newHead
}