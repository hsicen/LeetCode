package com.hsicen.leetcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.leetcode.databinding.ActivityMainBinding
import com.hsicen.leetcode.singleTask.SingleTask1Activity

/**
 * 作者：hsicen  2020/5/21 9:23
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：taskAffinity
 */
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSingleTask.setOnClickListener {
            val intent = Intent(this, SingleTask1Activity::class.java)
            startActivity(intent)
        }
    }
}
