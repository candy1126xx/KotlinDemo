package com.candy1126xx.kotlindemo.ViewModel

import com.candy1126xx.kotlindemo.View.HomeView

/**
 * ViewModel具有接收指令 -> 改变自身属性 -> 改变view的功能
 * 在set方法中调用view的相关方法 实现这个功能
 * 实际上，HomeViewModel是HomeView中所有控件内部变量的集合
 */
class HomeViewModel<T>(var view: HomeView<T>) {

    var text: String = ""
        set(value) {
            view.tv.text = value
        }

}