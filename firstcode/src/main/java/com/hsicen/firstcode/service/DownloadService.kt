package com.hsicen.firstcode.service

import android.app.IntentService
import android.content.Intent


class DownloadService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        //在子线程中运行,任务结束后会自动调用onDestroy

    }

}
