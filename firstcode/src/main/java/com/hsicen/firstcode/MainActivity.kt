package com.hsicen.firstcode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("hsc", "MainActivity：onCreate()")

        btn_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_second.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))

        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("hsc", "MainActivity：onNewIntent()")
    }
}
