package com.hsicen.firstcode

/**
 * 作者：hsicen  2020/7/9 9:12
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

inline fun printStr(str: String, block: (String) -> Unit) {
    println("printStr begin")
    block.invoke(str)
    println("printStr end")
}

inline fun runRunnable(crossinline block: () -> Unit) {
    println("runRunnable begin")

    val runnable = Runnable {
        block.invoke()
    }

    runnable.run()
    runnable.run()
    runnable.run()

    println("runRunnable end")
}


fun main() {
    println("Main begin")
    /*val str = ""

    printStr(str) {
        println("Lambda begin")
        if (it.isEmpty()) return@printStr
        println(it)
        println("Lambda end")
    }*/

    val str = ""
    runRunnable {
        println("Lambda begin")
        if (str.isEmpty()) return@runRunnable
        println("Lambda end")
    }

    println("Main end")
}
