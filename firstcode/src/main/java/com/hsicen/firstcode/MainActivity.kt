package com.hsicen.firstcode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
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

    private fun replaceFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.titleView, fragment)
        transaction.addToBackStack(null) //添加到返回栈中进行管理
        transaction.commit()
    }
}
