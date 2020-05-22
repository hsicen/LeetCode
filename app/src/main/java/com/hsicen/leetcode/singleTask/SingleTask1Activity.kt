package com.hsicen.leetcode.singleTask

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.leetcode.R
import kotlinx.android.synthetic.main.activity_single_task1.*

class SingleTask1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task1)

        btn_jump.setOnClickListener {
            val intent = Intent(this, SingleTask2Activity::class.java)
            startActivity(intent)
        }
    }
}
