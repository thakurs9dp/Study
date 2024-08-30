package com.s9dp.study._1_number_series

//https://www.javatpoint.com/java-programs#java-number-programs

fun isPrime(num: Int): Boolean {
    if (num <= 1) return false // 1 and numbers less than 1 are not prime
    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}


fun printPrimeNumberBetween(num : Int) {

    for (i in 1 until  num) {
        if (isPrime(i)) {
            print("$i ")
        }
    }
}


fun main() {
    println("${printPrimeNumberBetween(100)}")
}