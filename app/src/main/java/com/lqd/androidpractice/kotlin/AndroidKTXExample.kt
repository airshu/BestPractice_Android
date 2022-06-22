package com.lqd.androidpractice.kotlin

import androidx.collection.arraySetOf

class AndroidKTXExample {

    fun test1() {
        val combinedArraySet = arraySetOf(1,2,3) + arraySetOf(4,5,6)
        val newArraySet = combinedArraySet + 7 + 8


    }
}