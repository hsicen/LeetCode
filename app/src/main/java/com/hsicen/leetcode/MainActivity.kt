package com.hsicen.leetcode

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Handler().post {
            Log.d("hsc", "Handler  Post获取View的宽高参数： ${tvTest.width} * ${tvTest.height}")
        }
    }
}
