package com.hsicen.firstcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * 作者：hsicen  2020/7/6 8:54
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class LeftFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = arguments
        val name = arguments?.get("test")
    }

    fun newInstance(name: String): LeftFragment {
        val args = Bundle()
        args.putString("test", name)
        val fragment = LeftFragment()
        fragment.arguments = args
        return fragment
    }
}