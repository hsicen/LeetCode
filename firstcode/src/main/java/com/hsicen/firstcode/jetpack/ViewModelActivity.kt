package com.hsicen.firstcode.jetpack

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hsicen.firstcode.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {

    private val mSp by lazy {
        getPreferences(Context.MODE_PRIVATE)
    }

    private val mViewModel by lazy {
        val saveCount = mSp.getInt("sp_count", 0)
        ViewModelProviders.of(this, CountViewModelFactory(saveCount))
            .get(CountViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        btn_count.setOnClickListener {
            mViewModel.plusNum()
        }

        //数据监听
        mViewModel.countNum.observe(this, Observer { num ->
            tv_count.text = "$num"
        })
        mViewModel.userName.observe(this, Observer { name ->
            println(name)
        })
    }

    override fun onPause() {
        super.onPause()

        val edit = mSp.edit()
        edit.putInt("sp_count", mViewModel.countNum.value ?: 0)
        edit.apply()
    }
}
