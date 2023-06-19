package com.lqd.rn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.facebook.react.PackageList;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.soloader.SoLoader;
import com.lqd.rn.packages.ImagePickerPackage;
import com.lqd.rn.packages.IndexPackage;

import java.util.List;

public class MyReactActivity extends Activity implements DefaultHardwareBackBtnHandler {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    private final int OVERLAY_PERMISSION_REQ_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w("MyReactActivity", "onCreate>>>>>>>>>>>>>>>>>>>>>>>>");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }

        SoLoader.init(this, false);
        mReactRootView = new ReactRootView(this);
        List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
        //        packages.add(new MyReactNativePackage());
        packages.add(new IndexPackage());
        packages.add(new ImagePickerPackage());

        mReactInstanceManager = ReactInstanceManager.builder()
                //设置上下文
                .setApplication(getApplication()).setCurrentActivity(this).setBundleAssetName("index.android.bundle")
                //JS bundle主入口的文件名
                .setJSMainModulePath("index").addPackages(packages).setUseDeveloperSupport(BuildConfig.DEBUG)
                //设置创建时机
                .setInitialLifecycleState(LifecycleState.RESUMED)
                //JS异常回调
                .setRedBoxHandler(new MyRedBoxHandler()).build();
        mReactRootView.startReactApplication(mReactInstanceManager, "MyReactNativeApp", null);

        setContentView(mReactRootView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {

                }
            }
        }
        mReactInstanceManager.onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy(this);
        }

        if (mReactRootView != null) {
            mReactRootView.unmountReactApplication();
        }
    }

}

class MyRedBoxHandler implements RedBoxHandler {
    @Override
    public void handleRedbox(@Nullable String title, StackFrame[] stack, ErrorType errorType) {

        for (StackFrame stackFrame : stack) {
            Log.w("MyReactActivity", "=====handleRedbox   " + stackFrame.getMethod() + " " + stackFrame.getFileName() + " " + stackFrame.getLine() + " " + stackFrame.getColumn() + "  ");
        }
        //JS异常
        Log.w("MyReactActivity", ">>handleRedbox   " + title + "---------------- " + errorType + "  ");
    }

    @Override
    public boolean isReportEnabled() {
        return true;
    }

    @Override
    public void reportRedbox(Context context, String title, StackFrame[] stack, String sourceUrl, ReportCompletedListener reportCompletedListener) {
        Log.w("MyReactActivity", "-----handleRedbox   " + title + " sourceUrl:" + sourceUrl + "  ");
    }
}