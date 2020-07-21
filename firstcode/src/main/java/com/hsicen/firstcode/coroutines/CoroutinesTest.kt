package com.hsicen.firstcode.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 作者：hsicen  2020/7/21 9:19
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

fun main() {
    println(Thread.currentThread().name)
    runBlocking {
        println(Thread.currentThread().name)
        coroutineScope {
            println(Thread.currentThread().name)
            println("A")
            delay(500)
            println("B")
        }

        println("C")
    }

    println("D")
}

private fun test3() {
    runBlocking {
        println("A")
        delay(500)
        println("B")
    }

    println("C")
}

private fun test2() {
    println(Thread.currentThread().name)
    GlobalScope.launch {
        println(Thread.currentThread().name)
        println("B")
        delay(800)
        println("C")
        delay(500)
        println("D")
    }

    println("A")
    Thread.sleep(1000)
    println("E")
}

private fun testOrder() {
    println(Thread.currentThread().name)
    runBlocking {
        println("run: " + Thread.currentThread().name)

        launch {
            println("foo: " + Thread.currentThread().name)
            foo()
        }

        launch {
            println("bar: " + Thread.currentThread().name)
            bar()
        }
    }
}

private fun measureTime() {
    val time = measureTimeMillis {
        runBlocking {
            repeat(1000000) {
                launch {
                    println(".")
                }
            }
        }
    }

    println("Time: $time")
}

fun foo() {
    println(1)
    println(2)
    println(3)
}

fun bar() {
    println(4)
    println(5)
    println(6)
}

private fun test1() {
    println("Before runBlocking: ${Thread.currentThread().name}")

    runBlocking {
        println("Start runBlocking: ${Thread.currentThread().name}")

        launch {
            println("launch1: ${Thread.currentThread().name}")
            repeat(10) {
                println("launch1: $it")
                delay(20)
            }
        }

        launch {
            println("launch2: ${Thread.currentThread().name}")
            repeat(10) {
                println("launch2: $it")
                delay(25)
            }
        }

        launch {
            println("launch3: ${Thread.currentThread().name}")
            repeat(10) {
                println("launch3: $it")
                delay(15)
            }
        }

        println("End runBlocking: ${Thread.currentThread().name}")
    }

    println("After runBlocking: ${Thread.currentThread().name}")
}