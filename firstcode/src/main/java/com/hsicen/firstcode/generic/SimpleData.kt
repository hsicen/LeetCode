package com.hsicen.firstcode.generic

/**
 * 作者：hsicen  2020/7/19 22:38
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：泛型协变测试(只能读取数据)
 */
class SimpleData<out T>(private val data: T) {

    fun get(): T {
        return data
    }
}

open class Person(val name: String)

class Teacher(name: String) : Person(name)

class Student(name: String) : Person(name)

fun main() {
    val student = Student("小米")
    val data = SimpleData<Student>(student)
    handleData(data)
    val student1 = data.get()
}

fun handleData(data: SimpleData<Person>) {
    val person = data.get()
    person.name
}
