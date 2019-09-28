package com.night.leetcode.stack

import java.util.*

/**
 * <p>作者：Night  2019/2/1 9:36
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：LeetCode
 *
 * 设计一个栈，支持如下操作，这些操作的事件复杂度为O(1)
 *
 * push(x)
 * pop()
 * top()
 * getMin()
 *
 * 用一个栈来记录栈在各个时候的最小值
 */
class StackMin {
    private val data = Stack<Int>()
    //记录当前栈中的最小值
    private val temp = Stack<Int>()

    fun push(x: Int) {
        data.push(x)

        if (temp.isEmpty()) {
            //如果最小值栈为空，直接将数据压入栈中
            temp.push(x)
        } else {
            //选择当前元素和栈顶元素的最小值
            if (x > temp.peek()) {
                temp.push(temp.peek())
            } else {
                temp.push(x)
            }
        }
    }

    fun pop() {
        data.pop()
        temp.pop()
    }

    fun top(): Int {

        return data.peek()
    }

    fun getMin(): Int {
        return temp.peek()
    }
}