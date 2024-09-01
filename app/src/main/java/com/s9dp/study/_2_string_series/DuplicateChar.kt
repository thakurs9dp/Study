package com.s9dp.study._2_string_series

fun printDuplicateChar(input: String) {
    val inputToChar = input.toCharArray()
    for (i in inputToChar.indices) {
        for (j in i + 1..<inputToChar.size) {
            if (inputToChar[i] == inputToChar[j]) {
                print("${inputToChar[j]} ")
            }
        }
    }
}





fun main() {
    printDuplicateChar("SandeepSa")
}