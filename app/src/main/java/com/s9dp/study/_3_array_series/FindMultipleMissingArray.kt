package com.s9dp.study._3_array_series

import kotlin.math.min

fun findMissingNumbers(arrayList: ArrayList<Int>): List<Int> {

    val missingNumbers = mutableListOf<Int>()

    // Find the minimum and maximum values in the list
    val min = arrayList.minOrNull() ?: return emptyList()
    val max = arrayList.maxOrNull() ?: return emptyList()

    // Check each number in the range from min to max
    for (i in min..max) {
        if (i !in arrayList) {
            missingNumbers.add(i)
        }
    }

    return missingNumbers
}


fun findMissingNumberValue(arrayList : ArrayList<Int>) {

    val missingNumber = mutableListOf<Int>()

    //Find the min and max values in the the list
    val minNumber = arrayList.min()
    val maxNumber = arrayList.max()

    for (i in minNumber..maxNumber){
        if (i !in arrayList) {
            missingNumber.add(i)
        }

    }


    for (i in missingNumber) {
        print(" $i")
    }



}


fun main() {
 findMissingNumberValue(arrayListOf(1,2,3,5,6,8,9,15))
//
//    for (element in arrayList) {
//        print("$element ")
//    }



}