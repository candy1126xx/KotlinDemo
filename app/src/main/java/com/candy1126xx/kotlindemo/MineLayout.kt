package com.candy1126xx.kotlindemo

import org.jetbrains.anko.*

/**
 * Created by Administrator on 2017/4/21 0021.
 */
// 可以通过这种方式实现Activity、Fragment布局复用
class MineLayout<T>: AnkoComponent<T> {
    // 由Context生成View的方法
    override fun createView(ui: AnkoContext<T>) = with(ui){
        relativeLayout {
            textView {
                text = "这是我的"
            }.lparams {
                centerInParent()
            }
        }
    }
}