package com.hsicen.firstcode.jetpack

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 作者：hsicen  2020/7/27 19:28
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

@Entity
data class Book(var name: String, var page: Int, var author: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}