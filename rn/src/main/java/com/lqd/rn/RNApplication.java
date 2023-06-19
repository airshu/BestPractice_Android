package com.lqd.rn;

import android.app.Application;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.lqd.rn.packages.ImagePickerPackage;
import com.lqd.rn.packages.IndexPackage;

import java.util.List;




public class RNApplication extends Application implements ReactApplication {


    @Override
    public ReactNativeHost getReactNativeHost() {
        return new ReactNativeHost(this) {
            @Override
            public boolean getUseDeveloperSupport() {
                return false;
            }

            /**
             * 返回所有的Package
             * @return
             */
            @Override
            protected List<ReactPackage> getPackages() {
                List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
                packages.add(new IndexPackage());
                packages.add(new ImagePickerPackage());
                return packages;
            }
        };
    }
}
