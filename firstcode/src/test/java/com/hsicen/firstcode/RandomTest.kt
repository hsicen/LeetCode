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
}