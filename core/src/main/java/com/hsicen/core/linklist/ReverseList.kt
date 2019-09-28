package com.night.leetcode.linkedlist

import com.hsicen.core.linklist.ListNode

/**
 * <p>作者：Night  2019/2/1 14:33
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
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