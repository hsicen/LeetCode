package com.hsicen.firstcode.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.firstcode.R
import kotlinx.android.synthetic.main.activity_service.*

/**
 * 作者：hsicen  2020/7/19 15:17
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：服务样例
 */
class ServiceActivity : AppCompatActivity() {

    private val service by lazy {
        Intent(this, MyService::class.java)
    }

    private val musicService by lazy {
        Intent(this, MusicService::class.java)
    }

    private var downloadBinder: MyService.DownloadBinder? = null

    private val connection by lazy {
        object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName) {

            }

            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                downloadBinder = service as? MyService.DownloadBinder
                downloadBinder?.startDownload("")
                downloadBinder?.stopDownload()
            }
        }
    }

    private var musicBinder: MusicService.PlayBinder? = null
    private val musicConn by lazy {
        object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName) {
            }

            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                musicBinder = service as MusicService.PlayBinder
                musicBinder?.play()
                musicBinder?.stop()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)


        btn_start.setOnClickListener {
            startService(service)
        }

        btn_stop.setOnClickListener {
            stopService(service)
        }

        btn_bind.setOnClickListener {
            bindService(service, connection, Context.BIND_AUTO_CREATE)
        }

        btn_unbind.setOnClickListener {
            unbindService(connection)
        }


        music_start.setOnClickListener {
            bindService(musicService, musicConn, Context.BIND_AUTO_CREATE)
        }

        music_stop.setOnClickListener {
            unbindService(musicConn)
        }
    }
}