package com.lqd.androidpractice.kotlin.collections

fun main() {

    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B                      // 2
    val resultReduce = A.zip(B) { a, b -> "$a$b" } //

    println("$resultPairs   $resultReduce")
}