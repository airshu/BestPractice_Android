package com.lqd.androidpractice;

import android.app.Application;
import android.util.Log;

import com.lqd.androidpractice.util.ActivityManager;

import java.util.List;

public class LQDApplication extends Application {

    private static String TAG = "LQDApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        Integer f1 = 100, f2 = 100, f3 = 200, f4 = 200;
        Log.d(TAG, "" + (f1 == f2));
        Log.d(TAG, "" + (f3 == f4));


//        ActivityManager.INSTANCE.check();
    }

    public void test(List<ReplaceStrEntity> replaceStr) {
        new TestKotlin().test(replaceStr);

        TestKotlin.Companion.getStaticName();
        Log.d(TAG, "" + TestKotlin.LENGTH);

    }





}
