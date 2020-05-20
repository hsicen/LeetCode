package com.hsicen.leetcode

/**
 * 作者：hsicen  2020/5/20 10:25
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

fun main() {
    val user = User("123", "234")
    user.fullName

    val sumFun = { x: Int, y: Int ->
        x + y
    }

    sumFun.invoke(3, 4)
    sumFun(4, 5)
}


class User(val firstName: String, val SecondName: String)

fun Int.pow(point: Int) {
    println("result : " + { this * point })
}

val User.fullName
    get() = "$firstName $SecondName"
