package com.hsicen.firstcode.generic

/**
 * 作者：hsicen  2020/7/19 23:26
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：泛型的逆变
 */

interface Transfer<in T> {

    fun transform(t: T): String
}

fun main() {

    val personTrans: Transfer<Person> = object : Transfer<Person> {
        override fun transform(t: Person): String {

            return "The name is ${t.name}"
        }
    }

    handleTransform(personTrans)
}

fun handleTransform(trans: Transfer<Student>) {

    val student = Student("小米")
    trans.transform(student)
}
