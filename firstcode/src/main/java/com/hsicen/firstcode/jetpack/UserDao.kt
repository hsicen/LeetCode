package com.hsicen.firstcode.jetpack

import androidx.room.*

/**
 * 作者：hsicen  2020/7/27 8:55
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：User操作逻辑
 */

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("select * from User")
    fun loadAllUser(): List<User>

    @Query("delete from User where name=:name")
    fun deleteByName(name: String): Int

    @Query("select * from User where age > :age")
    fun loadTheAgeUser(age: Int): List<User>
}
