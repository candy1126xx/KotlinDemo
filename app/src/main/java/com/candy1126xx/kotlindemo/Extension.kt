package com.candy1126xx.kotlindemo

import android.view.View

/**
 * Created by Administrator on 2017/4/21 0021.
 */
// 扩展函数：为某各类添加功能
// 作用类似于java的装饰类，优点是不需要新建class
// 下面为View类添加了color方法，任何View及子类的实例都可以调用这个方法
fun View.color(colorRes: Int): Int {
    return resources.getColor(colorRes)
}

// 包级函数：相当于java的静态函数，不需要实例即可调用