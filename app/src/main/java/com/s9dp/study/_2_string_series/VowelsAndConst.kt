package com.s9dp.study._2_string_series

fun printVowelsAndConst(input: String) {

    val convertCharToLowerCase = input.lowercase()
    val inputStringToChar = convertCharToLowerCase.toCharArray()
    var countVowel = 0
    var countCont = 0

    for (i in inputStringToChar.indices) {
        when (inputStringToChar[i]) {
            'a', 'e', 'i', 'o', 'u' -> {
                print("${inputStringToChar[i]} ")
                countVowel++
            }
            in 'b'..'z' -> {
                print("${inputStringToChar[i]} ")
                countCont++
            }
        }
    }

    println("\nCount of vowels: $countVowel")
    println("Count of consonants: $countCont")
}



fun main() {
    printVowelsAndConst("sAndeep")
}