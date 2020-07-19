package com.hsicen.firstcode.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val mBinder by lazy {
        DownloadBinder()
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind()")

        return mBinder
    }

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand()")

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy()")
    }


    //Binder对象，进行通信
    inner class DownloadBinder : Binder() {

        fun startDownload(url: String) {

            Log.d(TAG, "startDownload()")
        }

        fun getProgress(): Int {
            Log.d(TAG, "getProgress()")

            return 0
        }

        fun stopDownload() {
            Log.d(TAG, "stopDownload()")
        }
    }

    companion object {
        private val TAG = MyService::class.java.simpleName
    }
}
