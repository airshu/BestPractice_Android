package com.lqd.androidpractice.kotlin.scopefunctions


/**
 * 跟let类似，但内部关联this，当需要处理多个语句时比较方便
 */
fun main() {


    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {                                                  // 1
            println("\tis empty? " + isEmpty())                    // 2
            println("\tlength = $length")
            length                                                 // 3
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")

}