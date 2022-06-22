package com.lqd.androidpractice.util

import android.app.Activity
import android.util.Log
import com.lqd.utils.ThreadHelper
import java.lang.ref.WeakReference

/**
 * @author: a564
 * @Date 2021/6/18
 */
object ActivityManager {



    open var oomActivity:Activity? = null

    var list: MutableList<WeakReference<Activity>> = arrayListOf<WeakReference<Activity>>()

    fun add(activity: Activity) {
        list.add(WeakReference(activity))
    }

    fun check() {
        ThreadHelper.runOnAsyncThread {
            while (true) {
                Log.d("###", "check======")
                list.forEach { it ->
                    Log.d("###", it.get().toString())
                }
                Thread.sleep(500)
            }
        }
    }
}