package com.hsicen.firstcode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hsc", "MainActivity：onCreate()")
    }

    override fun setContentView() = R.layout.activity_main

    override fun initVariable(savedInstanceState: Bundle?) {

    }

    override fun initView() {
        titleView.setTitle("首页")

        btn_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_second.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))

        }
    }

    override fun initData() {

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("hsc", "MainActivity：onNewIntent()")
    }
}
