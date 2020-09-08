package com.example.kttest

fun main() {
    var  pointer = Pointer(3,5)
    var  pointer2 = Pointer(6,9)

    var x = pointer + pointer2

    println("this is result: $x")
    test(3,4, lambda)
    test(3,4,::plus)

    test2("a-b-c","d-e-f-t","a-c-f-t")


}

private fun test(num1: Int, num2: Int,callback:(params1: Int,params2: Int) -> Int){
    var x = callback(num1,num2)
    println("this is $x")

}

val lambda = {num1: Int,num2: Int  -> num1 + num2 }

private fun plus(num1: Int,num2: Int): Int{

    return num1 + num2
}

private fun test2(vararg strings: String){
    strings.flatMap {
        it.split("-")
    }.map {
        print("$it  ")
    }
}