package com.hsicen.firstcode.provider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookStoreDatabaseHelper(context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {

    //参数分别为：Context，数据库名，Cursor，当前数据库版本号
    private val createBook = "create table Book(" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)"

    private val createCategory = "create table Category(" +
            "id integer primary key autoincrement," +
            "code integer," +
            "name text)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createBook) //创建表
        db.execSQL(createCategory)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists Book")
        db.execSQL("drop table if exists Category")

        onCreate(db)
    }
}