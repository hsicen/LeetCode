package com.hsicen.firstcode.net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsicen.firstcode.R
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
    }

    private fun request() {
        val url = URL("https://www.baidu.com")
        val conn = url.openConnection() as HttpURLConnection

        conn.requestMethod = "GET"
        conn.connectTimeout = 8000
        conn.readTimeout = 8000

        val sb = StringBuilder()
        BufferedReader(InputStreamReader(conn.inputStream)).use { reader ->
            reader.forEachLine {
                sb.append(it)
            }
        }

        conn.disconnect()
    }

    private fun post() {
        val url = URL("https://www.baidu.com")
        val conn = url.openConnection() as HttpURLConnection

        conn.requestMethod = "POST"
        conn.connectTimeout = 8000
        conn.readTimeout = 8000

        val output = DataOutputStream(conn.outputStream)
        output.writeBytes("username=admin&password=123456")

        conn.disconnect()
    }
}