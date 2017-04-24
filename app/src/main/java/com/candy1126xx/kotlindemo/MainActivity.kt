package com.candy1126xx.kotlindemo


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class MainActivity : FragmentActivity() {

    lateinit var container: ViewPager

    lateinit var nav: BottomNav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 这个方法的原型是verticalLayout(theme: Int = 0, init: _LinearLayout.() -> Unit)
        // 可以简写为verticalLayout(theme, init)
        // 第一个参数是int，主题资源的id；
        // 第二个参数是把_LinearLayout.()方法的返回值当作参数的fun
        // 当使用默认主题，即theme使用默认值0，写成verticalLayout（｛｝），简写为verticalLayout｛
        verticalLayout {

            // anko建立的布局不会自动生成id，需要手动添加
            container = viewPager {
                id = R.id.view_pager
                adapter = object : FragmentPagerAdapter(supportFragmentManager) {
                    override fun getItem(position: Int): Fragment {
                        return HomeFragment.newInstance()
                    }

                    override fun getCount() = 4

                }
            }.lparams(matchParent, 0, 1F)

            // object的作用相当于java的匿名内部类
            nav = bottomNav(object : BottomNav.OnTabClickListener {
                override fun onTabClick(index: Int) {
                    container.currentItem = index
                }
            }).lparams(matchParent, wrapContent)
        }

        nav.homeButton.performClick()
    }
}
