package com.lqd.androidpractice.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import com.lqd.androidpractice.R

class LaunchActivity2 : BaseLaunchActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lauch2)
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName)

        findViewById<Button>(R.id.btn2).setOnClickListener {
            startActivity(Intent(this@LaunchActivity2, LaunchActivity3::class.java))
        }

    }

}