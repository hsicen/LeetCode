package com.hsicen.leetcode

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hsicen.leetcode.function.ClickListener
import com.hsicen.leetcode.function.ClickView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val plusFun: (Int, Int) -> Int = { a: Int, b: Int ->
        a + b
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        invokeMe(fun(a: Int, b: Int): Int {
            return a + b
        })

        val a = ::invokeMe
        a(plusFun)
        a.invoke(plusFun)
        a.invoke(fun(a: Int, b: Int): Int {
            return a + b
        })

        val plusInt = fun(a: Int, b: Int): Int {
            return a + b
        }
    }

    override fun onResume() {
        super.onResume()
        val clickView = ClickView()
        clickView.setOnClickListener(object : ClickListener {
            override fun onClick() {

            }
        })

        clickView.setOnClickListener {

        }

        Handler().post {
            Log.d("hsc", "Handler  Post获取View的宽高参数： ${tvTest.width} * ${tvTest.height}")
        }

    }

    private fun invokeMe(method: (a: Int, b: Int) -> Int) {

    }
}
