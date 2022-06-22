package com.lqd.androidpractice.oom.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.lqd.androidpractice.R;
import com.lqd.androidpractice.util.ActivityManager;

import java.lang.ref.WeakReference;

/**
 * handler错误的用法，可能造成OOM
 *
 * @author: a564
 * @Date 2021/6/7
 */
public class OOMHandlerActivity extends Activity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ((EditText) findViewById(R.id.oom_handler_edit_text)).setText("aaaas");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom_handler);

        ActivityManager.INSTANCE.add(this);
        mHandler.sendEmptyMessageDelayed(1, 1000 * 60); //这里注意，当延迟时间较小时，Profile中Leaks显示为0
    }
}

