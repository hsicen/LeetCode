package com.hsicen.firstcode.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.hsicen.firstcode.MainActivity
import com.hsicen.firstcode.R

class MusicService : Service() {

    private val mBinder by lazy {
        PlayBinder()
    }

    //创建前台Service
    override fun onCreate() {
        super.onCreate()

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("music", "音乐服务", NotificationManager.IMPORTANCE_DEFAULT)
            nm.createNotificationChannel(channel)
        }

        val intent = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)

        val notification = NotificationCompat.Builder(this, "music")
            .setContentTitle("网易云音乐")
            .setContentText("正在运行")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setContentIntent(pi)
            .build()

        startForeground(1, notification)
    }

    override fun onBind(intent: Intent): IBinder {

        return mBinder
    }

    inner class PlayBinder : Binder() {

        fun play() {
        }

        fun stop() {
        }
    }
}
