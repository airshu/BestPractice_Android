package com.lqd.androidpractice.lifecycle

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.lqd.androidpractice.R

/**
 * 测试生命周期函数回调
 */
class LaunchActivity1 : BaseLaunchActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch1)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this@LaunchActivity1, LaunchActivity2::class.java))
        }

//        findViewById<TextView>(R.id.ah_textview).addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        })

//        Log.d(TAG, "onCreate")
    }


}