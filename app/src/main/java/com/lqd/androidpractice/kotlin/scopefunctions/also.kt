package com.lqd.androidpractice.kotlin.scopefunctions


class Person1(val name: String, val age: Int, val about:String) {
    fun writeCreationLog(it:String) {
        println("$name")
    }
}
//private class Person() {
//
//    var name:String? = null
//    var age:Int? = null
//    var about:String? = null
//}

/**
 * also 在赋值的同时可以做一些处理
 */
fun main() {
    val jake = Person1("Jake", 30, "Android developer")   // 1
        .also {
            println(it)
//            writeCreationLog(it)                         // 3
        }

    println("$jake")
}