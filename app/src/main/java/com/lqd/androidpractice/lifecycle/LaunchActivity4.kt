package com.lqd.androidpractice.lifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.lqd.androidpractice.R
import com.lqd.base.activity.BaseActivity

class LaunchActivity4 : BaseLaunchActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch4)

        findViewById<Button>(R.id.btn4).setOnClickListener {
            intent = Intent(this@LaunchActivity4, LaunchActivity2::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }
}