package com.s9dp.study._2_string_series

fun nonRepeatedChar(input: String) {
    for (i in input.indices) {
        var isCharRepeated = false

        for (j in input.indices) {
            if (i != j && input[i] == input[j]) {
                isCharRepeated = true
                break
            }
        }

        if (!isCharRepeated) {
            println("${input[i]}")
            return  // Stop after finding the first non-repeated character
        }
    }
}

fun main() {
    nonRepeatedChar("Ssandeep")
}