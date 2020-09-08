package com.example.kttest.package1

open class OutClass {
    private val str = "outClass params"
    inner class InnerClass{
        fun getOutInstance(): OutClass{
            return this@OutClass
        }
        private val innerStr = " this is innerClass"
        fun getStrInner():String{
            return  innerStr
        }
    }

    fun getOutStr(): String{
        return  str
    }
}