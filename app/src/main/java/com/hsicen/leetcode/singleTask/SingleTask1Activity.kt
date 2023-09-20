package com.hsicen.leetcode.singleTask

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.leetcode.databinding.ActivitySingleTask1Binding

class SingleTask1Activity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySingleTask1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySingleTask1Binding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnJump.setOnClickListener {
            val intent = Intent(this, SingleTask2Activity::class.java)
            startActivity(intent)
        }
    }
}
