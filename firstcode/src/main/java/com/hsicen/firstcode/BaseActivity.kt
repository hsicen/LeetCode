package com.hsicen.firstcode

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * 作者：hsicen  2020/7/5 11:16
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：基类Activity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("BaseActivity", javaClass.simpleName)
        supportActionBar?.hide()
        setContentView(setContentView())
        initVariable(savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()

        initData()
    }

    abstract fun setContentView(): Int

    abstract fun initVariable(savedInstanceState: Bundle?)

    abstract fun initView()

    abstract fun initData()
}