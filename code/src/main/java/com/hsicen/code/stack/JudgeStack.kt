package com.night.leetcode.stack

import java.util.LinkedList
import java.util.Stack

/**
 * <p>作者：Night  2019/1/31 15:46
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 */

/**
 * 判断整数队列是否为合法的出栈顺序
 */
fun judgeStack(numQueue: LinkedList<Int>): Boolean {
    val stack = Stack<Int>()
    val n = numQueue.size

    for (i in 1..n) {
        stack.push(i)
        while (!stack.isEmpty() && numQueue.peek() == stack.peek()) {
            stack.pop()
            numQueue.pop()
        }
    }

    if (!stack.isEmpty()) {
        return false
    }

    return true
}