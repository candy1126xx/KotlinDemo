package com.candy1126xx.kotlindemo.View

import android.widget.TextView
import org.jetbrains.anko.*

class HomeView<T> :
        AnkoComponent<T> {

    lateinit var tv: TextView

    override fun createView(ui: AnkoContext<T>) = with(ui) {
        relativeLayout {
            tv = textView {

            }.lparams {
                centerInParent()
            }
        }
    }

}