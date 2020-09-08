package com.example.kttest

data class Pointer(val num1: Int,val  num2: Int) {
    operator fun plus(other:Pointer) :Pointer {
        return Pointer(num1 + other.num1, num2 + other.num2)
    }
}