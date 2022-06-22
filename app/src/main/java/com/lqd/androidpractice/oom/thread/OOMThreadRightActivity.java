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
 * @author: a564
 * @Date 2021/6/18
 */
class OOMThreadRightActivity extends Activity {
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom_thread);

        //Thread也应该跟着Activity的销毁而结束
        new Thread(new MyRunnable()).start();

        asyncTask = new MyAsyncTask(this).execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时同时停止异步任务
        asyncTask.cancel(true);
        asyncTask = null;
    }

    static class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> weakReference;

        public MyAsyncTask(Context context) {
            weakReference = new WeakReference<>(context);
        }

        @Override
        protected Void doInBackground(Void... params) {
            SystemClock.sleep(10000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            OOMThreadRightActivity activity = (OOMThreadRightActivity) weakReference.get();
            if (activity != null) {
                //...
            }
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            SystemClock.sleep(10000);
        }
    }

}
