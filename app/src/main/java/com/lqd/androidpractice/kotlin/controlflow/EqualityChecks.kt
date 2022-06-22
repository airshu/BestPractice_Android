package com.lqd.androidpractice.kotlin.controlflow

/**
 * == 结构比较
 * === 引用比较
 */
fun main() {
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)   // 1
    println(authors === writers)
}