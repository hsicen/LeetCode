package com.hsicen.firstcode

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.hsicen.firstcode.service.ServiceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val timeReceiver by lazy {
        TimeBroadcastReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hsc", "MainActivity：onCreate()")
    }

    override fun setContentView() = R.layout.activity_main

    override fun initVariable(savedInstanceState: Bundle?) {
        val money: Money? = Money(2)


        val v = with(money) {
            val newV = this!!.value.plus(10)
            newV
        }

        val v2 = money?.let { vf ->
            val i = vf.value + 20
            "$i"
        } ?: ""

        val len = v2.length

        money.run {

        }


    }

    override fun initView() {
        titleView.setTitle("首页")

        btn_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_second.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))

        }

        btn_service.setOnClickListener {
            startActivity<ServiceActivity>(this) {
                putExtra("msg", "Hello")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        }
    }

    override fun initData() {
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        registerReceiver(timeReceiver, intentFilter)
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

    private fun sendOrder() {
        val intent = Intent("com.android.hsicen.broadcast.TEST_BROADCAST")
        intent.setPackage(packageName) //指定广播发送的应用程序，从而变成一条显式广播
        sendOrderedBroadcast(intent, null)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(timeReceiver)

        contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )?.apply {
            while (moveToNext()) {
                val name =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            }
            close()
        }
    }


    private fun saveStr(str: String) {
        openFileInput("")


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED
        ) {

            //未授权  请求授权
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)
        } else {
            //以授权 操作逻辑
            Log.d("hsc", "以授权")
        }
    }

    //权限申请结果回调
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            101 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //权限申请成功
                    Log.d("hsc", "授权成功")
                } else {
                    Log.d("hsc", "授权失败")
                }
            }
        }
    }


    inner class TimeBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time change", Toast.LENGTH_SHORT).show()
        }
    }
}
