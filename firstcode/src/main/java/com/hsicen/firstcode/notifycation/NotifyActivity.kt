package com.hsicen.firstcode.notifycation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.hsicen.firstcode.R
import com.hsicen.firstcode.SecondActivity

/**
 * 作者：hsicen  2020/7/15 8:27
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：Notify的使用
 */
class NotifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify)
    }

    private fun sendNotify() {
        //获取系统服务
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //8.0以上必须要设置Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        //创建点击时的意图  可以getActivity getBroadcast getService
        //第一个参数context，第二个为请求code，第三个为intent，第四个为PendingIntent行为，默认为0
        val intent = Intent(this, SecondActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)

        //创建通知
        val notification = NotificationCompat.Builder(this, "normal")
            .setContentText("This is content title") //只能显示一行
            .setContentText("This is content text") //只能显示一行
            .setSmallIcon(R.mipmap.ic_launcher) //顶部状态栏显示的图表
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)) //通知栏显示的图表
            .setStyle(NotificationCompat.BigTextStyle().bigText("This is content text")) //可以完全显示
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            ) //展示大图
            .setContentIntent(pi)
            .setAutoCancel(true)  //点击后自动取消通知
            .build()

        //发送通知  后面可以通过这个id取消通知
        manager.notify(1, notification)
    }
}