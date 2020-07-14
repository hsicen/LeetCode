package com.hsicen.firstcode.delegate

/**
 * 作者：hsicen  2020/7/14 8:37
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class MySet2<T>(private val helpSet: HashSet<T>) : Set<T> by helpSet {

    override fun isEmpty() = true

    fun add(e: T) = helpSet.add(e)

    fun helloWorld() = println("Hello World !!!")
}

fun main() {

    val mySet2 = MySet2<Int>(HashSet())
    mySet2.add(3)
    mySet2.contains(3)
    mySet2.isEmpty()
    mySet2.helloWorld()
    mySet2.size
}