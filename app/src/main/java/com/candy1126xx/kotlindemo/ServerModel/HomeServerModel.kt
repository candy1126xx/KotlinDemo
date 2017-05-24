package com.candy1126xx.kotlindemo.ServerModel

import com.candy1126xx.kotlindemo.ViewModel.HomeViewModel

/**
 * 一些View的属性是由ViewModel的几个属性共同决定的
 * 为了保持ViewModel的简单，增加这一层转换
 * 服务器、用户操作的都是这个Model
 */

class HomeServerModel<T> {

    var age: Int = 0

    var intro: String = ""

    // 服务器操作本地Model
    fun getServerData() {
        // Retrofit.create()...
        age = 15
        intro = "远程数据"
        setViewModelText()
    }

    // 用户操作本地Model
    fun changeAge() {
        age = 1
        setViewModelText()
    }

    // ------------------------------ServerModel与ViewModel绑定
    lateinit var model: HomeViewModel<T>

    fun bindViewModel(m: HomeViewModel<T>): HomeServerModel<T> {
        model = m
        return this
    }

    private fun setViewModelText(){
        model.text = if (age > 10) intro else "本地数据"
    }

}
