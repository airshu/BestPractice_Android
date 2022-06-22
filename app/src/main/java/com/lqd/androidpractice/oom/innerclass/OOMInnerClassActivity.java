package com.lqd.androidpractice.oom.innerclass;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lqd.androidpractice.R;
import com.lqd.androidpractice.util.ActivityManager;

import java.lang.ref.WeakReference;

/**
 * 匿名内部类造成的内存泄漏
 *
 * 尚未重现出来，😳
 *
 * @author: a564
 * @Date 2021/6/10
 */
public class OOMInnerClassActivity extends Activity {

    TextView textView;

    Handler mHanlder = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom_inner_class);


        EditText editText = findViewById(R.id.oom_edittext);
        textView = findViewById(R.id.oom_textview);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("aa") ) {
                    textView.setText(s.toString());
                    new Thread(() -> {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }).start();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}

