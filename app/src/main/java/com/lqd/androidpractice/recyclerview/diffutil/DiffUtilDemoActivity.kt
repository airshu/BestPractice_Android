package com.lqd.androidpractice.recyclerview.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.lqd.androidpractice.R
import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream

/**
 * 测试DiffUtil的作用
 */
class DiffUtilDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util_demo)

        val recyclerview: RecyclerView = findViewById(R.id.du_recycler_view)

        var adapter = DiffUtilAdapter()
        var list = mutableListOf<User>()

        list.add(User(1, "zhangsan1"))
        list.add(User(2, "zhangsan2"))
        list.add(User(9, "zhangsan9"))
        list.add(User(3, "zhangsan3"))
        list.add(User(6, "zhangsan6"))
        list.add(User(4, "zhangsan4"))
        list.add(User(5, "zhangsan5"))
        list.add(User(7, "zhangsan7"))
        list.add(User(8, "zhangsan8"))



        adapter.setDatas(list)
        recyclerview.adapter = adapter

        val btn: Button = findViewById(R.id.du_btn)
        btn.setOnClickListener { v: View? ->
            val newlist:List<User> = list.toMutableList().sortedWith(compareBy { it.id })
            newlist.get(3).name = "aaa"
            adapter.swap(newlist)
        }
    }


}