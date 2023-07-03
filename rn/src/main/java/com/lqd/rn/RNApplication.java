package com.lqd.rn;

import android.app.Application;
import android.util.Log;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.lqd.rn.packages.ImagePickerPackage;
import com.lqd.rn.packages.IndexPackage;

import java.util.List;


public class RNApplication extends Application implements ReactApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("RNApplication", "onCreate>>>>>>>>>>>");
        SoLoader.init(this, false);
    }

    @Override
    public ReactNativeHost getReactNativeHost() {
        return new ReactNativeHost(this) {
            @Override
            public boolean getUseDeveloperSupport() {
                return BuildConfig.DEBUG;
            }

            /**
             * 返回所有的Package
             * @return
             */
            @Override
            protected List<ReactPackage> getPackages() {
                Log.d("RNApplication", "getPackages>>>>>>>>>>>");
                List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
                packages.add(new IndexPackage());
                packages.add(new ImagePickerPackage());
                return packages;
            }
        };
    }
}
