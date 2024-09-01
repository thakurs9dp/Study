package com.s9dp.study._3_array_series

fun findMissingNumber(arrayList: ArrayList<Int>) : Int {

    val arraySizeExcepted = arrayList.size + 1

    val totalSum = arraySizeExcepted * (arraySizeExcepted + 1)/2

    var actualSum = 0

    for (i in 0 until arrayList.size) {
        actualSum += arrayList[i]
    }

    return totalSum - actualSum

}

fun main() {

    print(" ${findMissingNumber(arrayListOf(1,2,3,4,6,7))} ")

}