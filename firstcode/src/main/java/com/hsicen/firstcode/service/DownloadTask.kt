package com.hsicen.firstcode.service

import android.os.AsyncTask

/**
 * 作者：hsicen  2020/7/19 10:30
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：下载任务
 */

class DownloadTask : AsyncTask<String, Int, String>() {

    //主线程中运行
    override fun onPreExecute() {
        super.onPreExecute()
    }

    //子线程中运行
    override fun doInBackground(vararg params: String): String {
        return ""
    }

    //主线程中运行
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    //主线程中运行
    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
    }

}