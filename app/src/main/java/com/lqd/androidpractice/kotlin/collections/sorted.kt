package com.lqd.androidpractice.kotlin.collections

import kotlin.math.abs

fun main() {

    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    val natural = shuffled.sorted()                             // 2
    val inverted = shuffled.sortedBy { -it }                    // 3
    val descending = shuffled.sortedDescending()                // 4
    val descendingBy = shuffled.sortedByDescending { abs(it) }

    println("$natural \n$inverted \n$descending \n$descendingBy  ")

}