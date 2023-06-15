package com.lqd.rn.modules;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

public class IndexModule extends ReactContextBaseJavaModule {

    public IndexModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);

        //监听生命周期回调
        reactContext.addLifecycleEventListener(new LifecycleEventListener() {
            @Override
            public void onHostResume() {

            }

            @Override
            public void onHostPause() {

            }

            @Override
            public void onHostDestroy() {

            }
        });
    }

    @NonNull
    @Override
    public String getName() {
        return "IndexModule";
    }

    /**
     * 简单的方法回调
     * @param message
     * @param duration
     */
    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @Override
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
    }

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }


    //Callback测试
    @ReactMethod
    public void testCallback(String param1, Callback successCallback, Callback errorCallback) {
        try {
            successCallback.invoke(param1);
        } catch (Exception e) {
            errorCallback.invoke("error:" + e.getMessage());
        }
    }


    @ReactMethod
    public void testPromise(String param1, Promise promise) {
        promise.resolve(param1);
    }


    @ReactMethod
    public void testSendEvent(String param1) {
        WritableMap params = Arguments.createMap();
        params.putString("eventProperty", param1);
        setEvent("EventReminder", params);
    }


    /**
     * 往JS发送事件
     * @param eventName
     * @param params
     */
    public void setEvent(String eventName, WritableMap params) {
        getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }




}
