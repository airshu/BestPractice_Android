package com.lqd.androidpractice.oom.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.lqd.androidpractice.R;

import java.lang.ref.WeakReference;

/**
 * @author: a564
 * @Date 2021/6/18
 */
public class OOMHandlerRightActivity extends Activity {
    private MyHandler mHandler = new MyHandler(this);
    private TextView mTextView;

    //使用静态内部类
    private static class MyHandler extends Handler {
        private WeakReference<Context> reference;//使用弱引用

        public MyHandler(Context context) {
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            OOMHandlerRightActivity activity = (OOMHandlerRightActivity) reference.get();
            if (activity != null) {
                activity.mTextView.setText("");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom_handler);
        mTextView = (TextView) findViewById(R.id.textview);
        mHandler.sendEmptyMessageDelayed(1, 1000 * 60);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);//Activity销毁时同时移除handler的监听
    }
}
