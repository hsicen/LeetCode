package com.hsicen.firstcode.jetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 作者：hsicen  2020/7/24 9:10
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：实现计数功能的ViewModel
 */

class CountViewModel(countSaved: Int) : ViewModel() {

    var countNum = countSaved
}


class CountViewModelFactory(private val countSaved: Int) : ViewModelProvider.Factory {

    //create的执行时机和Activity的生命周期无关，不会因为Activity生命周期发生重复创建的问题
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountViewModel(countSaved) as T
    }
}