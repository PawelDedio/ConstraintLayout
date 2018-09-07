package com.dedio.constraintlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = createWallItems(100)

        val adapter = WallAdapter()
        adapter.items = items

        main_recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun createWallItems(requiredCount: Int): List<WallItem> {
        val list = ArrayList<WallItem>()

        for (i in 1..requiredCount) {
            val type = (1..3).random()
            list += WallItem(type)
        }

        return list
    }
}
