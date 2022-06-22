package com.lqd.androidpractice.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

/**
 * @author: a564
 * @Date 2021/6/4
 */
open class BaseLaunchActivity: Activity()  {

    protected val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName + "--->" + toString())
    }




    override fun onStart() {
        super.onStart()
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, Thread.currentThread().stackTrace[2].methodName+ "--->" + toString())
    }
}