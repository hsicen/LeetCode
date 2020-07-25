package com.hsicen.firstcode.jetpack

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 作者：hsicen  2020/7/25 15:54
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：Activity生命周期监听
 */
class LifeObserver(private val lifecycle: Lifecycle) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        println("onCreate()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        println("onStart()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        println("onResume()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        println("onPause()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        println("onStop()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        println("onDestroy()")
    }

    //任何生命周期变化都会回调这个方法
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        println("生命周期变化")
    }

    /*** 获取当前栈顶Activity或Fragment的状态*/
    fun getCurrentState() = lifecycle.currentState
}