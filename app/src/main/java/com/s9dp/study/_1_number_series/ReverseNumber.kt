package com.s9dp.study._1_number_series

fun printReverseNumber(num: Int) {

    var remb: Int
    var result = 0
    var temNum = num

    while (temNum != 0) {

        remb = temNum % 10
        result = result * 10 + remb
        temNum /= 10
    }

    print("$result")

}

fun main() {
    printReverseNumber(123456)
}