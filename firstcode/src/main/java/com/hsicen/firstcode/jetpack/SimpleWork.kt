package com.hsicen.firstcode.jetpack

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * 作者：hsicen  2020/7/28 8:22
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class SimpleWork(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        //默认运行在子线程
        Log.d("hsc", "SimpleWork is running ${Thread.currentThread().name}")
        return Result.retry()
    }
}
