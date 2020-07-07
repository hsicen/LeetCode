package com.hsicen.firstcode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * 作者：hsicen  2020/7/7 8:43
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：系统启动广播监听
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //逻辑处理
        Toast.makeText(context, "Boot Complete", Toast.LENGTH_SHORT).show()
        abortBroadcast()
    }
}
