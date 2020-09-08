package com.example.kttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var  pointer = Pointer(3,5)
        var  pointer2 = Pointer(6,9)

        var x = pointer + pointer2

        println("this is result: $x")
    }


}
