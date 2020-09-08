package com.example.kttest.package2

import java.io.Serializable

interface  State: Serializable
interface View {
    fun getCurrentState(): State
    fun  restoreState(state: State)
}