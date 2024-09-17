package com.s9dp.study.test


fun printTestReverseString(input : String) {

    val charCountMap = mutableMapOf<Char, Int>()

    for (char in input) {
        if (!char.isWhitespace()) {
            charCountMap[char] = charCountMap.getOrDefault(char , 0 ) + 1
        }
    }


    for ((char, count) in charCountMap){
        if (count > 1) {
            println("Char $char and count  $count times")
        }
    }

}


fun withoutMap(input: String) {
    for (i in input.indices){
        for (j in i + 1..<input.length) {
            if (input[i] == input[j]) {
                println(input[i])
            }
        }
    }
}


fun main() {
    printTestReverseString("Raj sandeep kumar think value")

    withoutMap("sandeepap")
}