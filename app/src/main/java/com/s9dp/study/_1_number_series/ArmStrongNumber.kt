package com.s9dp.study._1_number_series

import kotlin.math.pow
import kotlin.math.roundToInt

fun isNumberArmStrong(num: Int): Boolean {

    var originalNumber = num
    var rembider: Int
    var result = 0
    var power = 0

    while (originalNumber != 0) {
        originalNumber /= 10
        power++
    }

    originalNumber = num


    while (originalNumber != 0) {
        rembider = originalNumber % 10
        result = rembider.toDouble().pow(power.toDouble()).roundToInt()
        originalNumber /= originalNumber
    }


    return result == num

}

fun main() {
    print("The Number is arm strong : ${isNumberArmStrong(123)}")
}