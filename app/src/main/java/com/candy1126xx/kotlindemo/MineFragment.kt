package com.candy1126xx.kotlindemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.withArguments
import org.jetbrains.anko.textView

/**
 * Created by Administrator on 2017/4/21 0021.
 */
class MineFragment : Fragment() {

    // 工厂模式的实现方法
    companion object {
        fun newInstance(): MineFragment {
            val p1 = Pair<String, Any>("title", "mine")
            val p2 = Pair<String, Any>("tool", "kotlin")
            return MineFragment().withArguments(p1, p2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return MineLayout<MineFragment>().createView(AnkoContext.create(activity, MineFragment()))
    }

}