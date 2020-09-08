package com.example.kttest.package1

fun main() {
    var outClass = OutClass()
    var innerClass = outClass.InnerClass()
    val strOut = outClass.getOutStr()
    println("this is out $strOut")

    val innerStr =  innerClass.getStrInner()
    println("this is inner $innerStr")

}