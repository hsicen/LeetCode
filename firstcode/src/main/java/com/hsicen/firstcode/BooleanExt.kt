package com.hsicen.firstcode

import android.content.Context
import android.content.Intent

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

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}




