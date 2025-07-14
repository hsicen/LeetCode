package com.hsicen.code.hashmap

/**
 * @author: hsc
 * @date: 2025/7/14 16:54
 * @email: codinghuang@163.com
 * @description: 202.快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：
 *  1.对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 *  2.然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 *  3.如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例1：
 * 输入：19
 * 输出：true
 *
 * 示例2：
 * 输入：20
 * 输出：false
 */
object Solution202 {

    fun isHappy(n: Int): Boolean {
        fun nextNum(n: Int): Int {
            var sum = 0
            var num = n
            while (num > 0) {
                val temp = num % 10
                sum += temp * temp
                num /= 10
            }

            return sum
        }

        var slow = n
        var fast = nextNum(n)
        while (fast != 1 && slow != fast) {
            slow = nextNum(slow)
            fast = nextNum(nextNum(fast))
        }

        return fast == 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isHappy(19))
        println(isHappy(20))
    }
}