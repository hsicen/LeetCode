package com.hsicen.firstcode.jetpack

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 作者：hsicen  2020/7/25 17:43
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：用户信息
 */

@Entity
data class User(var name: String, var age: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
