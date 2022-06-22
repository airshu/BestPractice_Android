package com.lqd.androidpractice.kotlin.specialclasses

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total")                                               //4

}

fun main() {
    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty")

    BigBen.getBongs(12)
}

/**
 * 相当于静态对象，里面的函数都是静态的
 */
object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {        //2
        println("input Auth parameters = $username:$password")
    }
}


class BigBen {
    //伴生对象
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}