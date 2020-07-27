package com.hsicen.firstcode.jetpack

import androidx.room.*

/**
 * 作者：hsicen  2020/7/27 19:30
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */

@Dao
interface BookDao {

    @Insert
    fun insert(book: Book): Long

    @Delete
    fun delete(book: Book)

    @Update
    fun update(book: Book)

    @Query("select * from Book")
    fun listAll(): List<Book>
}