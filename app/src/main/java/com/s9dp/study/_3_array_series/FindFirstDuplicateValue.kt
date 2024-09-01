package com.s9dp.study._3_array_series

fun findFirstDuplicatedElements(arrayList : ArrayList<Int>) {

    for (i in 0 until  arrayList.size) {

        var isDuplicateFound = false

        for (j in i + 1.. arrayList.size) {

            if (arrayList[i] == arrayList[j]) {
                print("Find duplicate element ${arrayList[i]}")
                isDuplicateFound = true
                break
            }
        }


        if (isDuplicateFound) {
            break
        }

    }

}

fun main() {

    findDuplicateElements(arrayListOf(1,2,3,4,5,3))

}