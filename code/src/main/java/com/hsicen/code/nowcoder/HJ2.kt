package com.hsicen.code.nowcoder

import java.util.Scanner

/**
 * @author: hsc
 * @date: 2023/9/20 11:00
 * @email: codinghuang@163.com
 * description: HJ2 计算某字符出现次数
 *
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围：
 * 1≤ n ≤ 1000
 *
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：ABCabc
 *      A
 * 输出：2
 */

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    val str = read.nextLine()
    val target = read.nextLine()


    var count = 0
    str.forEach {
        if (target.equals(it.toString(), true)) count++
    }

    println(count)
}