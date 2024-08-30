package com.s9dp.study._1_number_series

fun isNumberPalindromeNumber(num : Int) : Boolean {

    var tempNumb = num
    var rembider = 0
    var result = 0

    while (tempNumb != 0) {
        rembider = tempNumb % 10
        result = result * 10 + rembider
        tempNumb /= 10
    }


    return result == num

}


fun main() {
    print("The number is palindrome Number " + isNumberPalindromeNumber(121))
}