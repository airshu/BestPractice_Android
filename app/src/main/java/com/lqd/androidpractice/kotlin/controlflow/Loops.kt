package com.lqd.androidpractice.kotlin.controlflow


fun main() {
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }

    fun eatACake() = println("Eat a Cake")
    fun bakeACake() = println("Bake a Cake")
    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 5) {                    // 1
        eatACake()
        cakesEaten ++
    }
    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)


    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
    for (animal in zoo) {                                   // 3
        println("Watch out, it's a ${animal.name}")
    }
}

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {             // 1
        return animals.iterator()                           // 2
    }
}