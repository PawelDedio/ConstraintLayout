package com.dedio.constraintlayout

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timeStart = System.currentTimeMillis()
        setContentView(R.layout.activity_main)

        val items = createWallItems(30)

        val adapter = WallAdapter()
        adapter.items = items

        main_recycler.adapter = adapter
        adapter.notifyDataSetChanged()
        main_recycler.post {
            val timeEnd = System.currentTimeMillis() - timeStart
            Log.e("MainActivity", "measured time inside recycler is: $timeEnd ms")
        }
        val timeEnd = System.currentTimeMillis() - timeStart
        Log.e("MainActivity", "measured time is: $timeEnd ms")
    }

    private fun createWallItems(requiredCount: Int): List<WallItem> {
        val list = ArrayList<WallItem>()

        for (i in 1..requiredCount) {
            list.add(WallItem(1))
            list.add(WallItem(2))
            list.add(WallItem(3))
        }

        return list
    }
}
