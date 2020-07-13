package com.hsicen.firstcode.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.net.Uri

/**
 * 作者：hsicen  2020/7/12 0:59
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：自定义Provider向外提供数据
 */
class BookProvider : ContentProvider() {
    /**
     * uri参数是ContentResolver调用增删改查传过来的，我们需要从这个参数解析出调用方希望访问的表和数据
     * 如：
     * content://com.hsicen.book.provider/table1  表示访问com.hsicen.book这个应用table1表中的数据
     * content://com.hsicen.book.provider/table1  表示访问com.hsicen.book这个应用table1表中id=1的数据
     *
     * 以路径结尾表示期望访问该表中所有数据，以id结尾表示期望访问该表中拥有相应id的数据，我们可以使用通配符来分辨
     * content://com.hsicen.book.provider/※
     * content://com.hsicen.book.provider/table/#
     *
     * 同时我们也可以使用UriMatcher来实现匹配内容URI的功能
     * addURI(authority, path, code)
     * code = match(uri)
     * addURI添加的code和match(uri)返回的code相同
     */

    private val bookDir = 0
    private val bookItem = 1
    private val categoryDir = 2
    private val categoryItem = 3
    private val authority = "com.hsicen.book.provider"
    private val dbName = "BookStore.db"
    private val dbVersion = 2

    private val dbHelper by lazy {
        context?.let {
            BookStoreDatabaseHelper(it, dbName, dbVersion)
        }
    }
    private val uriMatcher by lazy {
        UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(authority, "book", bookDir)
            addURI(authority, "book/#", bookItem)
            addURI(authority, "category", categoryDir)
            addURI(authority, "category/#", categoryItem)
        }
    }

    override fun onCreate() = dbHelper != null

    override fun query(
        uri: Uri, projection: Array<String>?,
        selection: String?, selectionArgs: Array<String>?, sortOrder: String?
    ) = dbHelper?.let {
        val db = it.readableDatabase
        when (uriMatcher.match(uri)) {
            bookDir -> db.query(
                "Book", projection, selection, selectionArgs,
                null, null, sortOrder
            )
            bookItem -> db.query(
                "Book", projection, "id = ?", arrayOf(uri.pathSegments[1]),
                null, null, sortOrder
            )

            categoryDir -> db.query(
                "Category", projection, selection, selectionArgs,
                null, null, sortOrder
            )

            categoryItem -> db.query(
                "Category", projection, "id = ?", arrayOf(uri.pathSegments[1]),
                null, null, sortOrder
            )

            else -> null
        }
    }

    override fun insert(uri: Uri, values: ContentValues?) = dbHelper?.let {
        val db = it.readableDatabase
        when (uriMatcher.match(uri)) {
            bookDir, bookItem -> {
                val id = db.insert("Book", null, values)
                Uri.parse("content://$authority/book/$id")
            }

            categoryDir, categoryItem -> {
                val id = db.insert("Category", null, values)
                Uri.parse("content://$authority/category/$id")
            }

            else -> null
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?,
        selection: String?, selectionArgs: Array<String>?
    ) = dbHelper?.let {
        val db = it.readableDatabase
        when (uriMatcher.match(uri)) {
            bookDir -> db.update("Book", values, selection, selectionArgs)
            bookItem -> db.update("Book", values, "id = ?", arrayOf(uri.pathSegments[1]))
            categoryDir -> db.update("Category", values, selection, selectionArgs)
            categoryItem -> db.update("Category", values, "id = ?", arrayOf(uri.pathSegments[1]))
            else -> 0
        }
    } ?: 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) =
        dbHelper?.let {
            val db = it.readableDatabase
            when (uriMatcher.match(uri)) {
                bookDir -> db.delete("Book", selection, selectionArgs)
                bookItem -> db.delete("Book", "id = ?", arrayOf(uri.pathSegments[1]))
                categoryDir -> db.delete("Category", selection, selectionArgs)
                categoryItem -> db.delete("Category", "id = ?", arrayOf(uri.pathSegments[1]))

                else -> 0
            }
        } ?: 0

    /**
     * 用于获取uri对象所对应的MIME类型  主要由3部分组成
     * 第一部分：以vnd开头
     * 第二部分：若URI以路径结尾：android.cursor.dir/; 若以id结尾：android.cursor.item/
     * 第三部分：最后接：vnd.<authority>.<path>
     */
    override fun getType(uri: Uri) = when (uriMatcher.match(uri)) {
        bookDir -> "vnd.android.cursor.dir/$authority.book"
        bookItem -> "vnd.android.cursor.item/$authority.book"
        categoryDir -> "vnd.android.cursor.dir/$authority.category"
        categoryItem -> "vnd.android.cursor.item/$authority.category"

        else -> null
    }
}
