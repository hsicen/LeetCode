package com.hsicen.firstcode.delegate

/**
 * 作者：hsicen  2020/7/14 8:26
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class MySet<T> : Set<T> {
    private val helpSet = HashSet<T>(1)

    override fun contains(element: T) = helpSet.contains(element)

    override fun containsAll(elements: Collection<T>) = helpSet.containsAll(elements)

    override fun isEmpty() = helpSet.isEmpty()

    override fun iterator(): Iterator<T> = helpSet.iterator()

    override val size: Int
        get() = helpSet.size
}