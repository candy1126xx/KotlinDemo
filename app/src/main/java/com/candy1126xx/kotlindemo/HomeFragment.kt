package com.candy1126xx.kotlindemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.support.v4.withArguments

/**
 * Created by Administrator on 2017/4/21 0021.
 */
class HomeFragment : Fragment() {

    // 工厂模式的实现方法
    companion object {
        fun newInstance(): HomeFragment {
            val p1 = Pair<String, Any>("title", "home")
            val p2 = Pair<String, Any>("time", "today")
            return HomeFragment().withArguments(p1, p2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = TextView(activity)
        v.text = "这是首页"
        return v

        // 下面这个写法会报错，不知道为什么
//        return UI {
//            verticalLayout {
//                textView {
//                    text = "这是首页"
//                }
//            }
//        }.view
    }

}
