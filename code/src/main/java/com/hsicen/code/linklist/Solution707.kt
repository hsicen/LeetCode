package com.hsicen.code.linklist

/**
 * @author: hsc
 * @date: 2025/7/4 11:05
 * @email: codinghuang@163.com
 * @description: 707.设计链表
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 *
 * 单链表中的节点应该具备两个属性：val 和 next 。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 *
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点下标从 0 开始。
 *
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 *
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 *
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。
 * 在插入完成后，新节点会成为链表的第一个节点。
 *
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 *
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
 * 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
 * 如果 index 比长度更大，该节点将不会插入到链表中。
 *
 * void deleteAtIndex(int index) 如果下标存在，则删除对应下标节点。
 */
object Solution707 {
    class MyLinkedList {
        private var size = 0
        private var head: ListNode? = ListNode(0)

        //获取链表中下标为 index 的节点的值，如果下标无效，则返回 -1
        fun get(index: Int): Int {
            if (index < 0 || index >= size) return -1

            var cur = head
            for (pos in 0..index) {
                cur = cur?.next
            }

            return cur?.`val` ?: -1
        }

        // 将一个值为 val 的节点插入到链表中第一个元素之前
        fun addAtHead(`val`: Int) {
            addAtIndex(0, `val`)
        }

        // 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
        fun addAtTail(`val`: Int) {
            addAtIndex(size, `val`)
        }

        // 将一个值为 val 的节点插入到链表中下标为 index 的节点之前
        // 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾
        // 如果 index 比长度更大，该节点将不会插入到链表中
        fun addAtIndex(index: Int, `val`: Int) {
            if (index > size) return

            val pos = Math.max(0, index)
            size++
            var pred = head
            for (i in 0 until pos) {
                pred = pred?.next
            }

            val node = ListNode(`val`)
            node.next = pred?.next
            pred?.next = node
        }

        //  如果下标存在，则删除对应下标节点
        fun deleteAtIndex(index: Int) {
            if (index < 0 || index >= size) return
            size--

            var pred = head
            for (i in 0 until index) {
                pred = pred?.next
            }

            pred?.next = pred.next?.next
        }

        fun printNode(msg: String) {
            var cur = head?.next
            print("$msg: ")
            while (cur != null) {
                print("${cur.`val`} ")
                cur = cur.next
            }
            println()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val myList = MyLinkedList()
        myList.addAtTail(1)
        myList.printNode("Step1")

        myList.addAtTail(3)
        myList.printNode("Step2")

        myList.addAtIndex(1, 2)
        myList.printNode("Step3")

        myList.get(1)
        myList.printNode("Step4")

        myList.deleteAtIndex(1)
        myList.printNode("Step5")

        myList.get(1)
        myList.printNode("Step6")
    }
}