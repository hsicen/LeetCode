package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/10 18:15
 * @email: codinghuang@163.com
 * @description: 07.链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 */
object Solution7 {

    // 假设链表A的长度为a，链表B的长度为b，则相交的节点的个数为c；
    // 则A走完a+b+c，B走完b+c+a，则A和B在c的起始位置相交
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null

        var pa = headA
        var pb = headB

        while (pa != pb) {
            pa = if (pa == null) headB else pa.next
            pb = if (pb == null) headA else pb.next
        }

        return pa
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }
}