package com.hsicen.firstcode

import kotlin.contracts.contract

/**
 * 作者：hsicen  2020/7/6 20:05
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：Boolean扩展
 */


fun Boolean.yes(block: () -> Unit): Boolean {
    block.invoke()
    return this
}

fun Boolean.no(block: () -> Unit): Boolean {
    block.invoke()
    return this
}

val Boolean.strName: String
    get() = this.toString()




