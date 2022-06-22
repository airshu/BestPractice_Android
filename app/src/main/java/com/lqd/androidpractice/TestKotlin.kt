package com.lqd.androidpractice

import android.util.Log

/**
 * Copyright (C) 2021 shjlone Inc. All rights reserved.
 *
 *
 * @author a564
 * @Date 4/19/21
 * @version 1.0
 *
 */

class TestKotlin {

    private var replaceStr1 = mutableListOf<ReplaceStrEntity>()

    fun test(replaceStr: List<ReplaceStrEntity>) {
        replaceStr?.let {
            replaceStr1.addAll(replaceStr)
            Log.d("======", "======")
        }


    }

    companion object {
        var name:String = "zhangsan"

        @JvmField
        var flag:Boolean = false

        const val LENGTH = 100

        @JvmStatic
        fun plus(x:Int, y:Int) {

        }

        fun getStaticName():String {
            return name
        }
    }

}