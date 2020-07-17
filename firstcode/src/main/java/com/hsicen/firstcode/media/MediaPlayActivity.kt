package com.hsicen.firstcode.media

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsicen.firstcode.R

class MediaPlayActivity : AppCompatActivity() {

    private val mPlayer by lazy {
        MediaPlayer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_media_play)
    }

    private fun initPlayer() {
        val assetsManager = assets
        val fd = assetsManager.openFd("musicSample.mp3")
        mPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mPlayer.prepare()
    }

    private fun play() {
        if (mPlayer.isPlaying.not()) {
            mPlayer.start()
        }
    }

    private fun pause() {
        if (mPlayer.isPlaying) {
            mPlayer.pause()
        }
    }

    private fun stop() {
        if (mPlayer.isPlaying) {
            mPlayer.reset()
            initPlayer()
        }
    }

    private fun destroy() {
        mPlayer.stop()
        mPlayer.release()
    }

}