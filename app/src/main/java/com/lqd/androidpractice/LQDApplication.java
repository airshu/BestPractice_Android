package com.lqd.androidpractice;

import android.app.Application;
import android.util.Log;


import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.lqd.rn.MyReactActivity;
import com.lqd.rn.RNApplication;
import com.lqd.rn.packages.ImagePickerPackage;
import com.lqd.rn.packages.IndexPackage;

import java.util.List;

public class LQDApplication extends RNApplication {

    private static String TAG = "LQDApplication";

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Log.d(TAG, "onCreate");
//        Integer f1 = 100, f2 = 100, f3 = 200, f4 = 200;
//        Log.d(TAG, "" + (f1 == f2));
//        Log.d(TAG, "" + (f3 == f4));
//        ActivityManager.INSTANCE.check();
//    }

    public void test(List<ReplaceStrEntity> replaceStr) {
        new TestKotlin().test(replaceStr);

        TestKotlin.Companion.getStaticName();
        Log.d(TAG, "" + TestKotlin.LENGTH);

    }

//    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
//        @Override
//        public boolean getUseDeveloperSupport() {
//            return BuildConfig.DEBUG;
//        }
//
//        @Override
//        protected List<ReactPackage> getPackages() {
//            List<ReactPackage> packages = new PackageList(this).getPackages();
//            packages.add(new CustomToastPackage());
//            return packages;
//        }
//
//    };
//
//    @Override
//    public ReactNativeHost getReactNativeHost() {
//        return mReactNativeHost;
//    }
}
