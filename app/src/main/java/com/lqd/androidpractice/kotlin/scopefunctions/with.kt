package com.lqd.androidpractice.kotlin.scopefunctions


class User(val name:String)

fun main() {

    val user = User(name = "zhangsan")
    with(user) {
        println("$name")
    }

    println("${user.name}")
}