package com.hsicen.firstcode.jetpack

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * 作者：hsicen  2020/7/27 9:01
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：应用数据库实例
 */

@Database(version = 3, entities = [User::class, Book::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun bookDao(): BookDao

    companion object {
        private var instance: AppDatabase? = null

        //数据库版本从1升级到2执行逻辑(新增表)
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book(id integer primary key autoincrement not null, name text not null, page integer not null )")
            }
        }

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknown'")
            }
        }

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let { return it }

            return Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3) //添加升级操作
                .fallbackToDestructiveMigration() //设置强制升级
                .allowMainThreadQueries()  //设置允许在主线程进行数据库操作  数据库操作属于耗时任务，Room默认是不允许在主线程进行数据库操作的，需要手动放到子线程去操作
                .build().also { instance = it }
        }
    }
}
