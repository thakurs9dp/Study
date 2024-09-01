package com.s9dp.study._3_array_series

fun findDuplicateElements(arrayList : ArrayList<Int>) {
    for (i in 0..<arrayList.size) {
        for (j in i +1..<arrayList.size) {
            if (arrayList[i] == arrayList[j] && i != j) {
                print("${arrayList[j]}")
            }
        }
    }
}


fun findDuplicateElementsUsingSet(arrayList: ArrayList<Int>) {

    val tempSet = mutableSetOf<Int>()

    for (i in arrayList) {
        if (!tempSet.add(i)) {
            print("$i")
        }
    }
}

fun findDuplicateElementsUsingMap(arrayList: ArrayList<Int>) {

    val tempMap = mutableMapOf<Int, Int>()
    val duplicates = mutableListOf<Int>()


    for (i in arrayList) {
        val count = tempMap[i]
        if (count == null) {
            tempMap[i] = 1  // First occurrence
        } else {
            tempMap[i] = count + 1  // Increment count for duplicate
        }
    }

    // Find elements with count > 1 (duplicates)
    for ((key, value) in tempMap) {
        if (value > 1) {
            println(key)
            duplicates.add(key)
        }
    }

}


fun main() {
    findDuplicateElementsUsingSet(arrayListOf(1,2,4,2,5,6,5,6,6))
}