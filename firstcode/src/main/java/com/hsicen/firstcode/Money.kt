package com.hsicen.firstcode

/**
 * 作者：hsicen  2020/7/6 20:34
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
data class Money(val value: Int) {

    operator fun plus(money: Money): Money {
        return Money(money.value + this.value)
    }

    operator fun minus(money: Money): Money {
        return Money(this.value - money.value)
    }

    operator fun times(money: Money): Money {
        return Money(this.value * money.value)
    }
}
