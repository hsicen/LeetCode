package com.hsicen.firstcode.net

/**
 * 作者：hsicen  2020/7/20 15:30
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

fun main() {

    val num = 1
    try {
        throw NullPointerException("空指针错误")
    } catch (e: Exception) {
        println("出错：catch ${e.localizedMessage}")
    } finally {
        println("出错：finally")
    }
}