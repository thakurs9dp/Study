package com.s9dp.study._2_string_series

fun isStringIsPalindrome(input : String) : Boolean {


    var reverseString = ""

    for (i in input.length-1 downTo 0) {
        reverseString += input[i]
    }


    return reverseString == input


}

fun main() {
    print("String is palindrome " +  isStringIsPalindrome("madam") )
}