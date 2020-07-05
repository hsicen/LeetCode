package com.hsicen.firstcode

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.layout_common_title.view.*

/**
 * 作者：hsicen  2020/7/5 12:25
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：TitleView封装
 */
class TitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_common_title, this)

        common_title.setNavigationOnClickListener {
            (context as? Activity)?.onBackPressed()
        }

        val typedArray = context.resources.obtainAttributes(attrs, R.styleable.TitleView)
        val titleStr = typedArray.getString(R.styleable.TitleView_title) ?: ""
        val backIcon = typedArray.getDrawable(R.styleable.TitleView_backIcon)

        common_title.title = titleStr
        common_title.navigationIcon = backIcon
        typedArray.recycle()
    }

    fun setTitle(str: String) {
        common_title.title = str
    }


}
