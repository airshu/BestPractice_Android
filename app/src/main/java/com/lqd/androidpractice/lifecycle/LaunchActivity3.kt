package com.lqd.androidpractice.lifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.lqd.androidpractice.R

class LaunchActivity3 : BaseLaunchActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch3)

        findViewById<Button>(R.id.btn3).setOnClickListener {
            startActivity(Intent(this@LaunchActivity3, LaunchActivity4::class.java))
        }

    }
}