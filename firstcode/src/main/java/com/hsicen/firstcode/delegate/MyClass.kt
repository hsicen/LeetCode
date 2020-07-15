package com.hsicen.firstcode.delegate

import kotlin.reflect.KProperty

/**
 * 作者：hsicen  2020/7/14 8:53
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class MyClass {

    var p by Delegate()
}

class Delegate {

    var propValue: Any? = null

    operator fun getValue(myClass: MyClass, property: KProperty<*>): Any? {

        return propValue
    }

    operator fun setValue(myClass: MyClass, property: KProperty<*>, any: Any?) {
        propValue = any
    }

}