package com.s9dp.study._15_partterns_mix


fun printStarRectPattern(num: Int) {

    for (i in 0..<4) {
        for (j in 0..i) {
            print(" * ")
        }
        println()
    }
}

fun printStarRectPatternRevers(num: Int) {

    for (i in 0..<4) {
        for (j in 4 downTo i) {
            print(" * ")
        }
        println()
    }
}

fun main() {
    printStarRectPatternRevers(5)
}






