package com.lqd.androidpractice.oom.innerclass;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lqd.androidpractice.R;

import java.lang.ref.WeakReference;

/**
 * @author: a564
 * @Date 2021/6/18
 */
class OOMInnerClassRightActivity extends Activity {
    public TextView textView;
    EditText editText;
    WeakTextWatcher weakTextWatcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom_inner_class);

        editText = findViewById(R.id.oom_edittext);
        textView = findViewById(R.id.oom_edittext);

        weakTextWatcher = new WeakTextWatcher(this);
        editText.addTextChangedListener(weakTextWatcher);
    }

    //使用静态内部类
    private static class WeakTextWatcher implements TextWatcher {
        //使用弱引用
        private WeakReference<OOMInnerClassRightActivity> activityWeakReference;

        WeakTextWatcher(OOMInnerClassRightActivity activity) {
            activityWeakReference = new WeakReference<OOMInnerClassRightActivity>(activity);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            OOMInnerClassRightActivity activity = activityWeakReference.get();
            if (activity != null) {
                activity.textView.setText(s.toString());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放监听
        editText.removeTextChangedListener(weakTextWatcher);
        weakTextWatcher = null;

    }
}
