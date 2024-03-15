package com.hsicen.code.nowcoder

import kotlin.system.measureTimeMillis

/**
 * 作者：hsicen  2023/10/3 16:54
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：HJ4 字符串分隔
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：abc
 * 输出：abc00000
 */
fun main() {

    // 按照指定长度拆分字符串
    fun splitStr(readStr: String, step: Int) {
        var pos = 0
        var len = readStr.length

        if (len == step) {
            println(readStr)
        } else if (len < step) {
            println(String(CharArray(step) { i ->
                if (i < len) readStr[pos + i] else '0'
            }))
        } else {
            while (len > step) {
                println(readStr.substring(pos, pos + step))
                pos += step
                len -= step
            }

            if (len > 0) {
                println(String(CharArray(step) { i ->
                    if (i < len) readStr[pos + i] else '0'
                }))
            }
        }
    }

    // 使用递归的方式处理
    fun splitStr2(readStr: String, step: Int) {
        val len = readStr.length

        if (len == step) {
            println(readStr)
        } else if (len < step) {
            println(String(CharArray(step) { i ->
                if (i < len) readStr[i] else '0'
            }))
        } else {
            println(readStr.substring(0, step))
            splitStr2(readStr.substring(step), step)
        }
    }

    val cost = measureTimeMillis {
        val readStr = readlnOrNull() ?: return
        splitStr2(readStr, 8)
    }

    println("耗时: ${cost / 1000f}ms")
}