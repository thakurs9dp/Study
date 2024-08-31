package com.s9dp.study._14_oops

class TestClass : AbstractTest() {
    override fun xyz() {
        println("Xyz")
    }
}


fun main() {
    val testClass : AbstractTest = TestClass()
    testClass.string = "Zyz"

}