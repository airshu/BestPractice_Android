package com.lqd.rn.modules;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.IllegalViewOperationException;

public class UIManagerModule extends ReactContextBaseJavaModule {


    public UIManagerModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);

    }


    /**
     * 发送消息给RN
     * @param reactContext
     * @param eventName
     * @param params
     */
    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    private static final String E_LAYOUT_ERROR = "E_LAYOUT_ERROR";

    @ReactMethod
    public void measureLayout(
            int tag,
            int ancestorTag,
            Promise promise) {
        try {
//            measureLayout(tag, ancestorTag, mMeasureBuffer);
//            WritableMap map = Arguments.createMap();
//            map.putDouble("relativeX ", PixelUtil.toDIPFromPixel(mMeasureBuffer[0]));
//            map.putDouble("relativeY", PixelUtil.toDIPFromPixel(mMeasureBuffer[1]));
//            map.putDouble("width", PixelUtil.toDIPFromPixel(mMeasureBuffer[2]));
//            map.putDouble("height", PixelUtil.toDIPFromPixel(mMeasureBuffer[3]));

//            promise.resolve(map);
        } catch (IllegalViewOperationException e) {
            promise.reject(E_LAYOUT_ERROR, e);
        }
    }


    @NonNull
    @Override
    public String getName() {
        return null;
    }
}
