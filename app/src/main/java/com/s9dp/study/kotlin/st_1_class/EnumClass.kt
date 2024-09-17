package com.s9dp.study.kotlin.st_1_class

enum class EnumClass(val number: Int) {

    SUNDAY(number = 1), MONDAY(number = 2), TUESDAY(number = 3)

}


fun main() {

    val day = EnumClass.MONDAY
    println("Day is $day")

}