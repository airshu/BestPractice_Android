package com.lqd.androidpractice.oom.thread;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.Nullable;

import com.lqd.androidpractice.R;

import java.lang.ref.WeakReference;

/**
 * 由于线程的使用造成的OOM实例
 *
 * @author: a564
 * @Date 2021/6/7
 */
class OOMThreadExampleActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom_thread);
//匿名内部类会有一个Activity的隐式引用，可能会造成OOM
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                SystemClock.sleep(10000);
                return null;
            }
        }.execute();
//——————test2
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(10000);
            }
        }).start();
    }
}
