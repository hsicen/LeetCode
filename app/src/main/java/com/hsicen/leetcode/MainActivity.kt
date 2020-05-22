package com.hsicen.leetcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.leetcode.singleTask.SingleTask1Activity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 作者：hsicen  2020/5/21 9:23
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：taskAffinity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_singleTask.setOnClickListener {
            val intent = Intent(this, SingleTask1Activity::class.java)
            startActivity(intent)
        }



    }
}
