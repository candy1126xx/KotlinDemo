package com.candy1126xx.kotlindemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.candy1126xx.kotlindemo.ServerModel.HomeServerModel
import com.candy1126xx.kotlindemo.View.HomeView
import com.candy1126xx.kotlindemo.ViewModel.HomeViewModel
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.withArguments

/**
 *  把HomeView作为Fragment的rootView，创建出HomeViewModel
 *  然后就可以通过改变HomeViewModel同步更新UI了
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
        rootView = HomeView<HomeFragment>()
        return rootView.createView(AnkoContext.create(activity, HomeFragment()))
    }


    lateinit var rootView: HomeView<HomeFragment>

    lateinit var model: HomeServerModel<HomeFragment>

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = HomeServerModel<HomeFragment>().bindViewModel(HomeViewModel(rootView))
        model.getServerData()

        view?.setOnClickListener {
            model.changeAge()
        }
    }

}
