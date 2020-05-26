package com.dedio.constraintlayout

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView

const val LINEAR_VIEWS = true
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timeStart = System.currentTimeMillis()
        setContentView(generateLayoutId())

        findViewById<NestedScrollView>(R.id.mainScroll).post {
            val timeEnd = System.currentTimeMillis() - timeStart
            Log.e("MainActivity", "measured time after post is: $timeEnd ms")
        }

        val timeEnd = System.currentTimeMillis() - timeStart
        Log.e("MainActivity", "measured time is: $timeEnd ms")

    }

    private fun generateLayoutId() = if(LINEAR_VIEWS) {
        R.layout.activity_main_static_linear
    } else {
        R.layout.activity_main_static_constraint
    }
}
