package com.hsicen.firstcode.media

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsicen.firstcode.R
import kotlinx.android.synthetic.main.activity_video_play.*

class VideoPlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)
    }

    private fun initPlayer() {
        //文件存放在在main/res/raw目录下，该目录下还可以存放音频文件
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        videoView.setVideoURI(uri)
    }

    private fun play() {
        if (videoView.isPlaying.not()) {
            videoView.start()
        }
    }

    private fun pause() {
        if (videoView.isPlaying) {
            videoView.pause()
        }
    }

    private fun rePlay() {
        if (videoView.isPlaying) {
            videoView.resume()
        }
    }

    private fun destroy() {
        videoView.suspend()
    }
}