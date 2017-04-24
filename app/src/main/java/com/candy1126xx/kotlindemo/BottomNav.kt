package com.candy1126xx.kotlindemo

import android.content.Context
import android.view.Gravity
import android.view.ViewManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by Administrator on 2017/4/20 0020.
 */

// 注意ViewManager，可选项还有Context、Activity，
// 不同之处在于new出实例后添加到的父View不同，注意ankoView(factory, theme, init)中的this
// 这里如果写Activity，BottomNav就不会显示在屏幕上
fun ViewManager.bottomNav(l: BottomNav.OnTabClickListener)
        = ankoView({ BottomNav(it, l) }, 0, {})

class BottomNav(context: Context, listener: BottomNav.OnTabClickListener) : LinearLayout(context) {

    // 没有找到可以引用R.style的方法，只有一个applyRecursively调整所有子View的样式
    var homeButton: LinearLayout
    lateinit var homeButtonImage: ImageView
    lateinit var homeButtonText: TextView

    var mineButton: LinearLayout
    lateinit var mineButtonImage: ImageView
    lateinit var mineButtonText: TextView

    init {
        verticalPadding = dimen(R.dimen.bottom_nav_text_to_image)

        homeButton = verticalLayout {
            layoutParams = LayoutParams(0, wrapContent, 1F)
            homeButtonImage = imageView(R.drawable.icon_home, R.drawable.icon_home_checked, {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
            }).lparams(dimen(R.dimen.bottom_nav_image_size), dimen(R.dimen.bottom_nav_image_size)) {
                gravity = Gravity.CENTER_HORIZONTAL
            }
            homeButtonText = textView {
                text = "首页"
                // 如果写textSize = sp(12)，字会变得很大
                textSizeDimen = R.dimen.bottom_nav_text_size
            }.lparams {
                topMargin = dimen(R.dimen.bottom_nav_text_to_image)
                gravity = Gravity.CENTER_HORIZONTAL
            }
            onClick {
                homeButtonImage.imageResource = R.drawable.icon_home_checked
                mineButtonImage.imageResource = R.drawable.icon_home
                homeButtonText.textColor = color(R.color.bottom_nav_text_checked_color)
                mineButtonText.textColor = color(R.color.bottom_nav_text_color)
                listener.onTabClick(0)
            }
        }
        // .lparams 和 layoutParams = LayoutParams(0, wrapContent, 1F)
        // fun lparams(width, height, init)定义在open class _LinearLayout(ctx: Context)中，
        // 即只有在_LinearLayout中的子View才能调用lparams

        mineButton = verticalLayout {
            layoutParams = LayoutParams(0, wrapContent, 1F)
            mineButtonImage = imageView {
                scaleType = ImageView.ScaleType.CENTER_INSIDE
            }.lparams(dimen(R.dimen.bottom_nav_image_size), dimen(R.dimen.bottom_nav_image_size)) {
                gravity = Gravity.CENTER_HORIZONTAL
            }
            mineButtonText = textView {
                text = "我的"
                textSizeDimen = R.dimen.bottom_nav_text_size
            }.lparams {
                topMargin = dimen(R.dimen.bottom_nav_text_to_image)
                gravity = Gravity.CENTER_HORIZONTAL
            }
            onClick {
                homeButtonImage.imageResource = R.drawable.icon_home
                mineButtonImage.imageResource = R.drawable.icon_home_checked
                homeButtonText.textColor = color(R.color.bottom_nav_text_color)
                mineButtonText.textColor = color(R.color.bottom_nav_text_checked_color)
                listener.onTabClick(1)
            }
        }
    }

    interface OnTabClickListener {
        fun onTabClick(index: Int)
    }
}