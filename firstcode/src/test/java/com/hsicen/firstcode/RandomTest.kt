package com.hsicen.firstcode

import org.junit.Test
import kotlin.random.Random

/**
 * 作者：hsicen  2020/7/5 23:01
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class RandomTest {

    lateinit var mTitleView: TitleView

    @Test
    fun testRandom() {
        val random = Random(47)

        repeat(20) {
            println((1..20).random(random))
        }
    }

    @Test
    fun booleanExt() {
        val b = true
        println(b.strName)

        val sampleStr = "Hello Kotlin"
        val capitalize = sampleStr.capitalize()
        val reversed = sampleStr.reversed()

        val repeat = sampleStr.repeat(3)
        println(repeat)
    }

    @Test
    fun moneyTest() {
        val money1 = Money(1)
        val money2 = Money(2)
        val money3 = Money(3)
        val money4 = Money(4)
        val money5 = Money(5)

        val plusMoney = money1 + money2 + money3 + money4 + money5
        println(plusMoney.value)

        val minusMoney = money5 - money4 + money3 - money2 + money1
        println(minusMoney.value)
    }
}