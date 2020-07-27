package com.hsicen.firstcode.jetpack

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 作者：hsicen  2020/7/27 9:01
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：应用数据库实例
 */

@Database(version = 1, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let { return it }

            return Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                .build().also { instance = it }
        }
    }
}
