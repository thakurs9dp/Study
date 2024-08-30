package com.s9dp.study._1_number_series

//1. Write a Program to print feb series

fun printFebSeries(num: Int) {
    var prevNumber = 0
    var nextNumber = 1
    var result: Int

    for (i in 0..num) {
        print(" $prevNumber ")
        result = prevNumber + nextNumber
        prevNumber = nextNumber
        nextNumber = result
    }

}

fun main() {
    printFebSeries(10)
}