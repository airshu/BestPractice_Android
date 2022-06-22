package com.lqd.androidpractice.kotlin.scopefunctions


private class Person {

    var name:String? = null
    var age:Int? = null
    var about:String? = null
}

fun main() {


    val jake = Person()                                     // 1
    val stringDescription = jake.apply {                    // 2
        name = "Jake"                                       // 3
        age = 30
        about = "Android developer"
    }.toString()

}