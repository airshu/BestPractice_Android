package com.lqd.rn.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;

public class RNActivity1 extends ReactActivity {


    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {

        //暴露各种回调
        return new ReactActivityDelegate(this, getMainComponentName()) {

            @Override
            public String getMainComponentName() {
                return "index";
            }

            @Override
            protected void onPause() {
                super.onPause();
            }

            @Override
            protected void onResume() {
                super.onResume();
            }

            @Override
            protected void onDestroy() {
                super.onDestroy();
            }
        };
    }


}
