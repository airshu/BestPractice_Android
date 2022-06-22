package com.lqd.androidpractice.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lqd.androidpractice.R

/**
 * 测试RecyclerView中的缓存池
 */
class PoolTestActivity : AppCompatActivity() {

    private val TAG: String = "PoolTestActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pool_test)

        var tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText("1111"))
        tabLayout.addTab(tabLayout.newTab().setText("2222"))
        tabLayout.addTab(tabLayout.newTab().setText("3333"))
        var viewPager = findViewById<ViewPager2>(R.id.viewpager2)

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                val fragment = TestFragment()
                val bundle = Bundle()
                bundle.putInt("pos", position)
                fragment.arguments = bundle
                return fragment
            }

            override fun getItemCount(): Int {
                return 3
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            viewPager.currentItem = tab.position

        }.attach()
    }
}

data class User(val name: String, val age: Int)

class TestFragment() : Fragment() {

    companion object {
        fun newInstance(pos: Int): TestFragment {
            val fg = TestFragment()
            val bundle = Bundle()
            bundle.putInt("pos", pos)
            fg.arguments = bundle
            return fg
        }

        var recycledViewPool = MyRecycledViewPool()
    }

    var fragmentPosition: Int = -1
    lateinit var recyclerView: RecyclerView
    var mDatas = arrayListOf<String>(
        "1",
        "2",
        "3",
        "4",
        "5",
        "11",
        "12",
        "13",
        "14",
        "15",
        "1",
        "2",
        "3",
        "4",
        "5",
        "11",
        "12",
        "13",
        "14",
        "15"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frament_pool_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentPosition = arguments?.get("pos") as Int
        recyclerView = view.findViewById(R.id.recycler_view);
        var linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.recycleChildrenOnDetach = true
        recyclerView.layoutManager = linearLayoutManager
        //设置缓存池大小
        //这里因为是测试，所有的viewType都为0
        TestFragment.recycledViewPool.setMaxRecycledViews(0, 10)
        //共用缓存池
        recyclerView.setRecycledViewPool(TestFragment.recycledViewPool)
        var adapter = TestAdapter(mDatas, fragmentPosition)
        recyclerView.adapter = adapter

    }

    class TestAdapter(val datas: ArrayList<String>, val fragmentPosition: Int) :
        RecyclerView.Adapter<MyViewHolder>() {
        private val TAG: String = "TestAdapter"
        override fun getItemCount(): Int {
            return datas.size
        }

        override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
            Log.d(TAG,"${fragmentPosition}==onBindViewHolder: position=$position, pool.size()=${TestFragment.recycledViewPool.getRecycledViewCount(0)}  ---- ${viewHolder.itemViewType}")
            viewHolder.tv.text = datas.get(position)
        }

        override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
            var holder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false))
            Log.d(TAG,"${fragmentPosition}==onCreateViewHolder: pool.size()=${TestFragment.recycledViewPool.getRecycledViewCount(0)} ---- ${holder.itemViewType}")
            return holder
        }

    }

}

class MyRecycledViewPool : RecyclerView.RecycledViewPool() {

    var num = 0
    override fun getRecycledView(viewType: Int): RecyclerView.ViewHolder? {
        return super.getRecycledView(viewType)
    }

    override fun putRecycledView(scrap: RecyclerView.ViewHolder?) {
        super.putRecycledView(scrap)
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tv: TextView = view.findViewById(R.id.text_view)

}