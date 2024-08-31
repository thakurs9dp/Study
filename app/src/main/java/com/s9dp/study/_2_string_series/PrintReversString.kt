package com.s9dp.study._2_string_series

fun reverseString(input  : String) {
    var result = ""
    for (i in input.length -1 downTo  0) {
        result += input[i]
    }
    print(result)
}

fun main() {
    reverseString("Sandeep Kumar")
}