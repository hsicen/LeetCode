package com.night.leetcode.stack

import java.util.Stack

/**
 * <p>作者：Night  2019/1/31 16:58
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Dagger2Demo
 *
 * 利用栈实现队列
 *
 * push
 * pop
 * peek
 * empty
 */

class HscQueue {
    private val data = Stack<Int>()
    private val temp = Stack<Int>()

    fun push(x: Int) {
        while (data.isNotEmpty()) {
            temp.push(data.peek())
            data.pop()
        }

        temp.push(x)

        while (temp.isNotEmpty()) {
            data.push(temp.peek())
            temp.pop()
        }
    }

    fun pop(): Int {
        val peek = data.peek()
        data.pop()
        return peek
    }

    fun peek() = data.peek()

    fun empty(): Boolean = data.isEmpty()

}

