package com.hsicen.firstcode.coroutines

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.system.measureTimeMillis

/**
 * 作者：hsicen  2020/7/21 9:19
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

fun main() {

}

suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { sc ->
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                sc.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let {
                    sc.resume(it)
                } ?: sc.resumeWithException(RuntimeException("response body is null"))
            }
        })
    }
}


private fun test8() {
    runBlocking(Dispatchers.IO) {
        println("A" + Thread.currentThread().name)
        val result = request("www.baidu.com")
        println(result)
        println("B" + Thread.currentThread().name)
    }
}


suspend fun request(url: String): String {
    return suspendCoroutine {
        println("C" + Thread.currentThread().name)
        it.resume("Hello")
    }
}

private fun test7() {
    runBlocking {
        println("A" + Thread.currentThread().name)
        val result = withContext(Dispatchers.Default) {
            println("B" + Thread.currentThread().name)
            delay(500)
            10 + 5
        }
        println("C" + Thread.currentThread().name)
        println("D $result " + Thread.currentThread().name)
        println("E" + Thread.currentThread().name)
    }
}

private fun test6() {
    runBlocking {
        println("A" + Thread.currentThread().name)

        val result1 = async(Dispatchers.IO) {
            delay(500)
            println("B" + Thread.currentThread().name)
            5 + 5
        }

        println("C" + Thread.currentThread().name)
        val result2 = async(Dispatchers.IO) {
            delay(500)
            println("D" + Thread.currentThread().name)
            4 + 3
        }

        println("E" + Thread.currentThread().name)
        println(result1.await() + result2.await())
        println("F" + Thread.currentThread().name)
    }
}

private fun test5() {
    val projectJob = Job()
    val scope = CoroutineScope(projectJob)

    println(Thread.currentThread().name)
    scope.launch(Dispatchers.IO) {
        println(Thread.currentThread().name)
        println("A")
    }

    println("B")
    projectJob.cancel()
}

private fun test4() {
    println(Thread.currentThread().name)
    runBlocking {
        println(Thread.currentThread().name)
        coroutineScope() {
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
    println(Thread.currentThread().name)
    runBlocking(Dispatchers.IO) {
        println(Thread.currentThread().name)
        println("A")
        delay(500)
        println("B")
    }

    println(Thread.currentThread().name)
    println("C")
}

private fun test2() {
    println(Thread.currentThread().name)
    GlobalScope.launch() {
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

        launch(Dispatchers.IO) {
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