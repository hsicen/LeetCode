package com.hsicen.code.stack

import java.util.LinkedList

/**
 * <p>作者：Night  2019/1/31 16:18
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Dagger2Demo
 */

class stackWithQueue {
    private val data = LinkedList<Int>()
    private val temp = LinkedList<Int>()

    fun push(x: Int) {
        while (data.isNotEmpty()) {
            temp.push(data.peek())
            data.pop()
        }

        temp.add(x)

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

    fun top(): Int {

        return data.peek()
    }

    fun empty(): Boolean {
        return data.isEmpty()
    }
}