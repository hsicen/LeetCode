package com.hsicen.core.nowcode

import java.util.Scanner

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
    val readStr = Scanner(System.`in`).nextLine()
    if (readStr.isNullOrEmpty()) return

    0 in readStr.toByteArray()

}